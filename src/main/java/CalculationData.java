/**
 * ����8���ȼ���״̬ת�Ʊ�
 * ����Ҫ��������
 */

import java.io.*;
import java.security.Provider;
import java.text.DecimalFormat;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class CalculationData {
    private WritableWorkbook workbook;
    private WritableSheet sheet;

    CalculationData() {
    }

    ;

    CalculationData(String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
        }
        //����������
        workbook = Workbook.createWorkbook(file);
        //�����µ�һҳ
        //��һ��������ʾsheetҳ�����֣��ڶ���������ʾ�ڼ�ҳ
        sheet = workbook.createSheet("sheet1", 0);
    }

    public void addOneCell(int line, int column, String data) throws RowsExceededException, WriteException {
        sheet.addCell(new Label(column, line, data));
    }

    public void printCell() throws IOException, WriteException {
        workbook.write();
        workbook.close();
    }


    public static void main(String[] args) throws IOException, RowsExceededException, WriteException {
        DecimalFormat df = new DecimalFormat("0.00000 ");
        DecimalFormat dff = new DecimalFormat("0 ");
        String filename = "yzr_perpkt_d";
        CalculationData cl = new CalculationData("/Users/a/Desktop/generateJavaCode/0205/" + filename + ".xls");
//        CalculationData preData = new CalculationData("/Users/a/Desktop/generateJavaCode/0205/preData.xlsx");
        File file = new File("/Users/a/Desktop/generateJavaCode/0205/byte50.txt");
        FileWriter writer = new FileWriter("/Users/a/Desktop/generateJavaCode/0205/data.txt", false);
//		CalculationData cl = new CalculationData("/Users/a/Desktop/generateJavaCode/PREDData/JavaGData/"+filename+".xls");
//		File file = new File("/Users/a/Desktop/generateJavaCode/PREDData/originData/yzr_perpkt.txt");
        Reader mr = null;
        String a = "";
        int SORT_T = 1000000;
        int SORT = 7200;

        double tt[] = new double[SORT_T];
        double t1[] = new double[SORT];
        double predic[] = new double[SORT];
        int r1[] = new int[SORT];
        int i = 0;
        int j = 0;
        int k = 0;
        int tempchar = 0;
        double E1 = 0;
        double E2 = 0;
        double D1 = 0;
        double D2 = 0;
        double R1[] = new double[10];
        double R2[] = new double[10];
        double R3[] = new double[10];
        double R4[] = new double[10];
        double R5[] = new double[10];
        double R6[] = new double[10];
        double R7[] = new double[10];
        double R8[] = new double[10];
        double RR[] = new double[9];

        /* 1.������� */
        try {
            mr = new InputStreamReader(new FileInputStream(file));
            // mr.read();
            // mr.read();
            while ((tempchar = mr.read()) != -1 && i < SORT) {

                if (((char) tempchar) == '\r') {
//                    System.out.println(a);
                    t1[i] = Double.parseDouble(a);
                    a = "";
                    i++;
                } else if (((char) tempchar) == '\n') {
                    //t1[i] = Double.parseDouble(a);
                    a = "";
                    //i++;
                } else if (((char) tempchar) == ' ') {
                    a = "";

                } else {
                    a = a + String.valueOf((char) tempchar);

                }
            }

            if (a.compareTo("") != 0) {
                t1[i] = Double.parseDouble(a);
                //System.out.println(a);
                a = "";
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
         * for (i = 0; i < SORT; i++) { System.out.print(i + 1 + " ");
         * System.out.println("T1=" + t1[i]); } System.out.println();
         * System.out.println();
         */

        /*
         * i = 0; k = 25; j = 0; double x = 0; String temp; while(i < SORT_T) { x +=
         * tt[i]; i++; k--; if(k == 0) { //System.out.println(i+ "   "+ j);
         *
         * t1[j] = x; temp = String.valueOf(t1[j])+ "\n"; writer.write(temp); x = 0; k =
         * 25; j++; } } writer.close();
         *
         * for(i=0; i<10; i++) { System.out.print(i+1 + " "); System.out.println("T1=" +
         * t1[i]); } System.out.println(); System.out.println();
         *
         */
        /* 2.�����ֵ�ͱ�׼�� */
        for (i = 0; i < SORT; i++) {
            E1 = E1 + t1[i];
            //System.out.println((i+1) + ": " + E1 + " " + t1[i]);
        }
        E1 = E1 / (SORT);
        for (i = 0; i < SORT; i++) {
            D1 = D1 + (t1[i] - E1) * (t1[i] - E1);
            //System.out.println("D1=" + df.format(D1));
        }
        D1 = Math.sqrt(D1 / SORT);

        System.out.println("E1=" + df.format(E1));
        System.out.println("D1=" + df.format(D1));

        System.out.println();
        System.out.println();

        /* 3.����ÿһ�����ݵĵȼ� */
        for (i = 0; i < (SORT); i++) {
            if (t1[i] < E1 - 3 * D1) {
                r1[i] = 1;
            } else if (t1[i] >= E1 - 3 * D1 && t1[i] < E1 - 2 * D1) {
                r1[i] = 2;
            } else if (t1[i] >= E1 - 2 * D1 && t1[i] < E1 - D1) {
                r1[i] = 3;
            } else if (t1[i] >= E1 - D1 && t1[i] < E1) {
                r1[i] = 4;
            } else if (t1[i] >= E1 && t1[i] < E1 + D1) {
                r1[i] = 5;
            } else if (t1[i] >= E1 + D1 && t1[i] < E1 + 2 * D1) {
                r1[i] = 6;
            } else if (t1[i] >= E1 + 2 * D1 && t1[i] < E1 + 3 * D1) {
                r1[i] = 7;
            } else if (t1[i] >= E1 + 3 * D1) {
                r1[i] = 8;
            }

        }

        /* 4.������ʹ�ӡ */
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
                if (r1[i] == 1) {
                    R1[0]++;
                } else if (r1[i] == 2) {
                    R2[0]++;
                } else if (r1[i] == 3) {
                    R3[0]++;
                } else if (r1[i] == 4) {
                    R4[0]++;
                } else if (r1[i] == 5) {
                    R5[0]++;
                } else if (r1[i] == 6) {
                    R6[0]++;
                } else if (r1[i] == 7) {
                    R7[0]++;
                } else if (r1[i] == 8) {
                    R8[0]++;
                }
            } else if (r1[i] == 1) {
                R1[0]++;
                R1[r1[i + 1]]++;
            } else if (r1[i] == 2) {
                R2[0]++;
                R2[r1[i + 1]]++;
            } else if (r1[i] == 3) {
                R3[0]++;
                R3[r1[i + 1]]++;
            } else if (r1[i] == 4) {
                R4[0]++;
                R4[r1[i + 1]]++;
            } else if (r1[i] == 5) {
                R5[0]++;
                R5[r1[i + 1]]++;
            } else if (r1[i] == 6) {
                R6[0]++;
                R6[r1[i + 1]]++;
            } else if (r1[i] == 7) {
                R7[0]++;
                R7[r1[i + 1]]++;
            } else if (r1[i] == 8) {
                R8[0]++;
                R8[r1[i + 1]]++;
            }
        }

        System.out.println(R1[0] + "   " + R1[1] + "   " + R1[2] + "   " + R1[3] + "   " + R1[4] + "   " + R1[5] + "   "
                + R1[6] + "   " + R1[7] + "   " + R1[8]);
        System.out.println(R2[0] + "   " + R2[1] + "   " + R2[2] + "   " + R2[3] + "   " + R2[4] + "   " + R2[5] + "   "
                + R2[6] + "   " + R2[7] + "   " + R2[8]);
        System.out.println(R3[0] + "   " + R3[1] + "   " + R3[2] + "   " + R3[3] + "   " + R3[4] + "   " + R3[5] + "   "
                + R3[6] + "   " + R3[7] + "   " + R3[8]);
        System.out.println(R4[0] + "   " + R4[1] + "   " + R4[2] + "   " + R4[3] + "   " + R4[4] + "   " + R4[5] + "   "
                + R4[6] + "   " + R4[7] + "   " + R4[8]);
        System.out.println(R5[0] + "   " + R5[1] + "   " + R5[2] + "   " + R5[3] + "   " + R5[4] + "   " + R5[5] + "   "
                + R5[6] + "   " + R5[7] + "   " + R5[8]);
        System.out.println(R6[0] + "   " + R6[1] + "   " + R6[2] + "   " + R6[3] + "   " + R6[4] + "   " + R6[5] + "   "
                + R6[6] + "   " + R6[7] + "   " + R6[8]);
        System.out.println(R7[0] + "   " + R7[1] + "   " + R7[2] + "   " + R7[3] + "   " + R7[4] + "   " + R7[5] + "   "
                + R7[6] + "   " + R7[7] + "   " + R7[8]);
        System.out.println(R8[0] + "   " + R8[1] + "   " + R8[2] + "   " + R8[3] + "   " + R8[4] + "   " + R8[5] + "   "
                + R8[6] + "   " + R8[7] + "   " + R8[8]);
        System.out.println();
        System.out.println();

        // �������
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

        // ����ת�Ƹ���
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

        System.out
                .println("------------------------------------------------------------------------------------------");
        System.out.println("    " + "   1   " + "       2   " + "       3   " + "       4   " + "       5   "
                + "       6   " + "       7   " + "       8   ");
        System.out.println("1   " + df.format(R1[1]) + "   " + df.format(R1[2]) + "   " + df.format(R1[3]) + "   "
                + df.format(R1[4]) + "   " + df.format(R1[5]) + "   " + df.format(R1[6]) + "   " + df.format(R1[7])
                + "   " + df.format(R1[8]) + "   " + df.format(R1[9]));
        System.out.println("2   " + df.format(R2[1]) + "   " + df.format(R2[2]) + "   " + df.format(R2[3]) + "   "
                + df.format(R2[4]) + "   " + df.format(R2[5]) + "   " + df.format(R2[6]) + "   " + df.format(R2[7])
                + "   " + df.format(R2[8]) + "   " + df.format(R2[9]));
        System.out.println("3   " + df.format(R3[1]) + "   " + df.format(R3[2]) + "   " + df.format(R3[3]) + "   "
                + df.format(R3[4]) + "   " + df.format(R3[5]) + "   " + df.format(R3[6]) + "   " + df.format(R3[7])
                + "   " + df.format(R3[8]) + "   " + df.format(R3[9]));
        System.out.println("4   " + df.format(R4[1]) + "   " + df.format(R4[2]) + "   " + df.format(R4[3]) + "   "
                + df.format(R4[4]) + "   " + df.format(R4[5]) + "   " + df.format(R4[6]) + "   " + df.format(R4[7])
                + "   " + df.format(R4[8]) + "   " + df.format(R4[9]));
        System.out.println("5   " + df.format(R5[1]) + "   " + df.format(R5[2]) + "   " + df.format(R5[3]) + "   "
                + df.format(R5[4]) + "   " + df.format(R5[5]) + "   " + df.format(R5[6]) + "   " + df.format(R5[7])
                + "   " + df.format(R5[8]) + "   " + df.format(R5[9]));
        System.out.println("6   " + df.format(R6[1]) + "   " + df.format(R6[2]) + "   " + df.format(R6[3]) + "   "
                + df.format(R6[4]) + "   " + df.format(R6[5]) + "   " + df.format(R6[6]) + "   " + df.format(R6[7])
                + "   " + df.format(R6[8]) + "   " + df.format(R6[9]));
        System.out.println("7   " + df.format(R7[1]) + "   " + df.format(R7[2]) + "   " + df.format(R7[3]) + "   "
                + df.format(R7[4]) + "   " + df.format(R7[5]) + "   " + df.format(R7[6]) + "   " + df.format(R7[7])
                + "   " + df.format(R7[8]) + "   " + df.format(R7[9]));
        System.out.println("8   " + df.format(R8[1]) + "   " + df.format(R8[2]) + "   " + df.format(R8[3]) + "   "
                + df.format(R8[4]) + "   " + df.format(R8[5]) + "   " + df.format(R8[6]) + "   " + df.format(R8[7])
                + "   " + df.format(R8[8]) + "   " + df.format(R8[9]));

        /* 5.���Excel�ļ�*/
        String head[] = {"", "1", "2", "3", "4", "5", "6", "7", "8"};

        //���б�������
        for (i = 0; i < 9; i++) {
            cl.addOneCell(0, i, head[i]);
        }
        //��һ��
        for (i = 0; i < 8; i++) {
            cl.addOneCell(i + 1, 0, String.valueOf(i + 1));
        }
        //����
        for (j = 0; j < 9; j++) {
            cl.addOneCell(1, j + 1, String.valueOf(df.format(R1[j + 1])));
            cl.addOneCell(2, j + 1, String.valueOf(df.format(R2[j + 1])));
            cl.addOneCell(3, j + 1, String.valueOf(df.format(R3[j + 1])));
            cl.addOneCell(4, j + 1, String.valueOf(df.format(R4[j + 1])));
            cl.addOneCell(5, j + 1, String.valueOf(df.format(R5[j + 1])));
            cl.addOneCell(6, j + 1, String.valueOf(df.format(R6[j + 1])));
            cl.addOneCell(7, j + 1, String.valueOf(df.format(R7[j + 1])));
            cl.addOneCell(8, j + 1, String.valueOf(df.format(R8[j + 1])));

        }

        cl.printCell();
        RR[1] = R1[9];
        RR[2] = R2[9];
        RR[3] = R3[9];
        RR[4] = R4[9];
        RR[5] = R5[9];
        RR[6] = R6[9];
        RR[7] = R7[9];
        RR[8] = R8[9];
        // 计算预测包数，t1[i]是第i个时间点的包数，r1[i]是第i个时间点的流量等级 Ri[9]是这个等级对应的转移等级
        predic[0] = t1[0];
        writer.write(df.format(predic[0])+"\n");
//        preData.addOneCell(1,1,String.valueOf(predic[0]));
        for (int l = 1; l < SORT; l++) {
            predic[l] =  RR[r1[l-1]]/r1[l-1] * t1[l-1];
            writer.write(df.format(predic[l])+"\n");
//            preData.addOneCell(l+1,1,String.valueOf(df.format(predic[0])));
        }

//        for (int r: r1) {
//            System.out.print(r+" ");
//        }
    }
}
