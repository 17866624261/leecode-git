import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
import java.io.IOException;
//import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.DecimalFormat;


public class CalculationData {
    public static void main(String[] args) throws IOException {
        DecimalFormat df = new DecimalFormat("0.00000 ");
        //DecimalFormat dff = new DecimalFormat( "0 ");
        File file = new File("/Users/a/Desktop/generateJavaCode/32node-160kb-10000s-1s.txt");
        //FileWriter writer =  new FileWriter("C:\\Users\\Nanyou\\Desktop\\NS2\\data.txt", false);
        Reader mr = null;
        String a = "";
        //int SORT_T = 1000000;  //一百万个数据
        int SORT = 10000;      //5万个数据

        //double tt[] = new double[SORT_T];
        double data[] = new double[SORT];       //data[]用来读取文件中的数据并存储
        int data_rank[] = new int[SORT];              //data_rank[]用来对应data[]数组对应下标数据的等级
        int i = 0;
        //int j = 0;
        //int k = 0;
        int tempchar = 0;                      //临时读取文件中的数据
        double E1 = 0;                          //所有数据的平均值
        //double E2 = 0;
        double D1 = 0;                          //所有数据的方差
        //double D2 = 0;
        double R1[] = new double[10];
        double R2[] = new double[10];
        double R3[] = new double[10];
        double R4[] = new double[10];
        double R5[] = new double[10];
        double R6[] = new double[10];
        double R7[] = new double[10];
        double R8[] = new double[10];

        /* 1.获得数据    */
        try {
            mr = new InputStreamReader(new FileInputStream(file));
            //mr.read();
            //mr.read();
            while ((tempchar = mr.read()) != -1 && i < SORT) {

                if (((char) tempchar) == '\n') {
                    data[i] = Double.parseDouble(a);
                    //System.out.println(a);
                    a = "";
                    i++;
                } else if (((char) tempchar) == '\r') {
                    //a="";
                    //System.out.println("这里是刚R");
                } else if (((char) tempchar) == ' ') {
                    a = "";

                } else {
                    a = a + String.valueOf((char) tempchar);
                    //System.out.println(a);
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        for (i = 0; i < SORT; i++) {
            System.out.print(i + 1 + " ");
            System.out.println("data=" + data[i]);
        }
        System.out.println();
        System.out.println();

	/*
		i = 0;
		k = 25;
		j = 0;
		double x = 0;
		String temp;
		while(i < SORT_T) {
			x += tt[i];
			i++;
			k--;
			if(k == 0) {
				//System.out.println(i+ "   "+ j);

				data[j] = x;
				temp = String.valueOf(data[j])+ "\n";
				writer.write(temp);
				x = 0;
				k = 25;
				j++;
			}
		}
		writer.close();

		for(i=0; i<10; i++) {
			System.out.print(i+1 + " ");
			System.out.println("data=" + data[i]);
		}
		System.out.println();
		System.out.println();

*/
        /* 2.计算均值和方差    */
        for (i = 0; i < (SORT); i++) {
            E1 = E1 + data[i];
            //System.out.println((i+1) + ": " + E1 + "   " + data[i]);
        }
        E1 = E1 / (SORT);
        for (i = 0; i < (SORT); i++) {
            D1 = D1 + (data[i] - E1) * (data[i] - E1);
        }
        D1 = Math.sqrt(D1 / SORT);

        System.out.println("均值=" + df.format(E1));
        System.out.println("方差=" + df.format(D1));

        // System.out.println();
        // System.out.println();
        // System.out.println("第一个数的数值为"+data[0]);
        // System.out.println("第9999个数的数值为"+data[9999]);
        // System.out.println();
        // System.out.println();
        /* 3.划分每一条数据的等级    */
        for (i = 0; i < (SORT); i++) {
            if (data[i] < E1 - 3 * D1) {
                data_rank[i] = 1;
                // System.out.println(data[i]+"的等级为1,为第"+i+"个数");
            } else if (data[i] >= E1 - 3 * D1 && data[i] < E1 - 2 * D1) {
                data_rank[i] = 2;
            } else if (data[i] >= E1 - 2 * D1 && data[i] < E1 - D1) {
                data_rank[i] = 3;
            } else if (data[i] >= E1 - D1 && data[i] < E1) {
                data_rank[i] = 4;
            } else if (data[i] >= E1 && data[i] < E1 + D1) {
                data_rank[i] = 5;
            } else if (data[i] >= E1 + D1 && data[i] < E1 + 2 * D1) {
                data_rank[i] = 6;
            } else if (data[i] >= E1 + 2 * D1 && data[i] < E1 + 3 * D1) {
                data_rank[i] = 7;
            } else if (data[i] >= E1 + 3 * D1) {
                data_rank[i] = 8;
            }

        }


        /* 4.表格计算和打印    */
        for (i = 0; i < 10; i++) {
            R1[i] = 0;
            R2[i] = 0;
            R3[i] = 0;
            R4[i] = 0;
            R5[i] = 0;
            R6[i] = 0;
            R7[i] = 0;
            R8[i] = 0;
        }

        for (i = 0; i < (SORT); i++) {
            if (i == SORT - 1) {
				/*if(data_rank[i] == 1) {
					R1[0]++;
				}else if(data_rank[i] == 2) {
					R2[0]++;
				}else if(data_rank[i] == 3) {
					R3[0]++;
				}else if(data_rank[i] == 4) {
					R4[0]++;
				}else if(data_rank[i] == 5) {
					R5[0]++;
				}else if(data_rank[i] == 6) {
					R6[0]++;
				}else if(data_rank[i] == 7) {
					R7[0]++;
				}else if(data_rank[i] == 8) {
					R8[0]++;
				}*/
                continue;
            } else if (data_rank[i] == 1) {
                R1[0]++;
                R1[data_rank[i + 1]]++;           //data_rank[i+1]就是data_rank[i]要转移到下一个数的等级
            } else if (data_rank[i] == 2) {
                R2[0]++;
                R2[data_rank[i + 1]]++;
            } else if (data_rank[i] == 3) {
                R3[0]++;
                R3[data_rank[i + 1]]++;
            } else if (data_rank[i] == 4) {
                R4[0]++;
                R4[data_rank[i + 1]]++;
            } else if (data_rank[i] == 5) {
                R5[0]++;
                R5[data_rank[i + 1]]++;
            } else if (data_rank[i] == 6) {
                R6[0]++;
                R6[data_rank[i + 1]]++;
            } else if (data_rank[i] == 7) {
                R7[0]++;
                R7[data_rank[i + 1]]++;
            } else if (data_rank[i] == 8) {
                R8[0]++;
                R8[data_rank[i + 1]]++;
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("第一列为Ri等级数据总数，行中后续为i等级转移到j等级数据总数");
        System.out.println();
        System.out.println("R1: " + R1[0] + "   " + R1[1] + "   " + R1[2] + "   " + R1[3] + "   " + R1[4] + "   " + R1[5] + "   " + R1[6] + "   " + R1[7] + "   " + R1[8]);
        System.out.println("R2: " + R2[0] + "   " + R2[1] + "   " + R2[2] + "   " + R2[3] + "   " + R2[4] + "   " + R2[5] + "   " + R2[6] + "   " + R2[7] + "   " + R2[8]);
        System.out.println("R3: " + R3[0] + "   " + R3[1] + "   " + R3[2] + "   " + R3[3] + "   " + R3[4] + "   " + R3[5] + "   " + R3[6] + "   " + R3[7] + "   " + R3[8]);
        System.out.println("R4: " + R4[0] + "   " + R4[1] + "   " + R4[2] + "   " + R4[3] + "   " + R4[4] + "   " + R4[5] + "   " + R4[6] + "   " + R4[7] + "   " + R4[8]);
        System.out.println("R5: " + R5[0] + "   " + R5[1] + "   " + R5[2] + "   " + R5[3] + "   " + R5[4] + "   " + R5[5] + "   " + R5[6] + "   " + R5[7] + "   " + R5[8]);
        System.out.println("R6: " + R6[0] + "   " + R6[1] + "   " + R6[2] + "   " + R6[3] + "   " + R6[4] + "   " + R6[5] + "   " + R6[6] + "   " + R6[7] + "   " + R6[8]);
        System.out.println("R7: " + R7[0] + "   " + R7[1] + "   " + R7[2] + "   " + R7[3] + "   " + R7[4] + "   " + R7[5] + "   " + R7[6] + "   " + R7[7] + "   " + R7[8]);
        System.out.println("R8: " + R8[0] + "   " + R8[1] + "   " + R8[2] + "   " + R8[3] + "   " + R8[4] + "   " + R8[5] + "   " + R8[6] + "   " + R8[7] + "   " + R8[8]);
        System.out.println();
        System.out.println();

        //计算概率
        for (i = 1; i < 9; i++) {
            if (R1[0] != 0)
                R1[i] = R1[i] / R1[0];
        }
        for (i = 1; i < 9; i++) {
            if (R2[0] != 0)
                R2[i] = R2[i] / R2[0];
        }
        for (i = 1; i < 9; i++) {
            if (R3[0] != 0)
                R3[i] = R3[i] / R3[0];
        }
        for (i = 1; i < 9; i++) {
            if (R4[0] != 0)
                R4[i] = R4[i] / R4[0];
        }
        for (i = 1; i < 9; i++) {
            if (R5[0] != 0)
                R5[i] = R5[i] / R5[0];
        }
        for (i = 1; i < 9; i++) {
            if (R6[0] != 0)
                R6[i] = R6[i] / R6[0];
        }
        for (i = 1; i < 9; i++) {
            if (R7[0] != 0)
                R7[i] = R7[i] / R7[0];
        }
        for (i = 1; i < 9; i++) {
            if (R8[0] != 0)
                R8[i] = R8[i] / R8[0];
        }

        //计算转移概率
        for (i = 1; i < 9; i++) {
            R1[9] += R1[i] * i;
            R2[9] += R2[i] * i;
            R3[9] += R3[i] * i;
            R4[9] += R4[i] * i;
            R5[9] += R5[i] * i;
            R6[9] += R6[i] * i;
            R7[9] += R7[i] * i;
            R8[9] += R8[i] * i;
        }

		/*
		System.out.println(dff.format(R1[0])+"   "+df.format(R1[1])+"   "+df.format(R1[2])+"   "+df.format(R1[3])+"   "+df.format(R1[4])+"   "+df.format(R1[5])+"   "+df.format(R1[6]));
		System.out.println(dff.format(R2[0])+"   "+df.format(R2[1])+"   "+df.format(R2[2])+"   "+df.format(R2[3])+"   "+df.format(R2[4])+"   "+df.format(R2[5])+"   "+df.format(R2[6]));
		System.out.println(dff.format(R3[0])+"   "+df.format(R3[1])+"   "+df.format(R3[2])+"   "+df.format(R3[3])+"   "+df.format(R3[4])+"   "+df.format(R3[5])+"   "+df.format(R3[6]));
		System.out.println(dff.format(R4[0])+"   "+df.format(R4[1])+"   "+df.format(R4[2])+"   "+df.format(R4[3])+"   "+df.format(R4[4])+"   "+df.format(R4[5])+"   "+df.format(R4[6]));
		System.out.println(dff.format(R5[0])+"   "+df.format(R5[1])+"   "+df.format(R5[2])+"   "+df.format(R5[3])+"   "+df.format(R5[4])+"   "+df.format(R5[5])+"   "+df.format(R5[6]));
		System.out.println(dff.format(R6[0])+"   "+df.format(R6[1])+"   "+df.format(R6[2])+"   "+df.format(R6[3])+"   "+df.format(R6[4])+"   "+df.format(R6[5])+"   "+df.format(R6[6]));
		*/
        System.out.println("    " + "   1   " + "       2   " + "       3   " + "       4   " + "       5   " + "       6   " + "       7   " + "       8   ");
        System.out.println("1   " + df.format(R1[1]) + "   " + df.format(R1[2]) + "   " + df.format(R1[3]) + "   " + df.format(R1[4]) + "   " + df.format(R1[5]) + "   " + df.format(R1[6]) + "   " + df.format(R1[7]) + "   " + df.format(R1[8]));
        System.out.println("2   " + df.format(R2[1]) + "   " + df.format(R2[2]) + "   " + df.format(R2[3]) + "   " + df.format(R2[4]) + "   " + df.format(R2[5]) + "   " + df.format(R2[6]) + "   " + df.format(R2[7]) + "   " + df.format(R2[8]));
        System.out.println("3   " + df.format(R3[1]) + "   " + df.format(R3[2]) + "   " + df.format(R3[3]) + "   " + df.format(R3[4]) + "   " + df.format(R3[5]) + "   " + df.format(R3[6]) + "   " + df.format(R3[7]) + "   " + df.format(R3[8]));
        System.out.println("4   " + df.format(R4[1]) + "   " + df.format(R4[2]) + "   " + df.format(R4[3]) + "   " + df.format(R4[4]) + "   " + df.format(R4[5]) + "   " + df.format(R4[6]) + "   " + df.format(R4[7]) + "   " + df.format(R4[8]));
        System.out.println("5   " + df.format(R5[1]) + "   " + df.format(R5[2]) + "   " + df.format(R5[3]) + "   " + df.format(R5[4]) + "   " + df.format(R5[5]) + "   " + df.format(R5[6]) + "   " + df.format(R5[7]) + "   " + df.format(R5[8]));
        System.out.println("6   " + df.format(R6[1]) + "   " + df.format(R6[2]) + "   " + df.format(R6[3]) + "   " + df.format(R6[4]) + "   " + df.format(R6[5]) + "   " + df.format(R6[6]) + "   " + df.format(R6[7]) + "   " + df.format(R6[8]));
        System.out.println("7   " + df.format(R7[1]) + "   " + df.format(R7[2]) + "   " + df.format(R7[3]) + "   " + df.format(R7[4]) + "   " + df.format(R7[5]) + "   " + df.format(R7[6]) + "   " + df.format(R7[7]) + "   " + df.format(R7[8]));
        System.out.println("8   " + df.format(R8[1]) + "   " + df.format(R8[2]) + "   " + df.format(R8[3]) + "   " + df.format(R8[4]) + "   " + df.format(R8[5]) + "   " + df.format(R8[6]) + "   " + df.format(R8[7]) + "   " + df.format(R8[8]));
    }
}
