package midtermexam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class Midexam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long systemTime = System.currentTimeMillis();
		
		InputStream in = null;
		int b[] = { 2, 4, 5, 6, 8, 9, 10, 11, 13, 14, 15, 16, 17, 19, 22, 23, 24, 25, 26, 27, 29 };
		String[] str_arr;
		String[] res_arr;
		double max = 0.0;
		double max_t = 0.0;
		int max_b = 0;
		int max_d = 0;

		double min = 10.0;
		double min_t = 0.0;
		int min_b = 0;
		int min_d = 0;

		try {
			URL u;

			for (int i = 0; i < b.length; i++) {
				for (int d = 100; d <= 1000; d += 10) {
					u = new URL("http://home.konkuk.ac.kr/~leehw/Site/nptest/file%20b" + b[i] + "_d" + d + ".txt");
					in = u.openStream();
					
					BufferedReader rd = new BufferedReader(new InputStreamReader(in));
					String str = readAll(rd);

					str_arr = str.split("\n");
					for (int k = 0; k < str_arr.length; k++) {
						res_arr = str_arr[k].split(",");
						for (int idx = 1; idx < res_arr.length; idx++) {
							if (Double.parseDouble(res_arr[idx]) > max) {
								max = Double.parseDouble(res_arr[idx]);
								max_t = Double.parseDouble(res_arr[0]);
								max_b = b[i];
								max_d = d;

							}
							if (Double.parseDouble(res_arr[idx]) < min) {
								min = Double.parseDouble(res_arr[idx]);
								min_t = Double.parseDouble(res_arr[0]);
								min_b = b[i];
								min_d = d;
							}
						}

					}

				}
			}
			System.out.println("b:" + max_b + "\td:" + max_d + "\tt:" + max_t + "\tf:" + max);
			System.out.println("b:" + min_b + "\td:" + min_d + "\tt:" + min_t + "\tf:" + min);
			
		} catch (IOException ex) {
			System.err.println(ex);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {

			}
		}
		systemTime = System.currentTimeMillis() - systemTime;
		System.out.println("Time : " + systemTime/1000);
	}

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();

	}
}
