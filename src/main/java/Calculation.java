import java.util.Scanner;
import java.util.Stack;

public class Calculation {
    public void getExpressionValue(String A){
        char[] arrayA = A.toCharArray();
        Stack<Integer> Value = new Stack<Integer>();
        Stack<Character> Operator =  new Stack<Character>();
        for(int i = 0;i < A.length();i++){
            int temp = 0;
            if(arrayA[i] >= '0' && arrayA[i] <= '9'){
                temp = arrayA[i] - '0';
                i = i + 1;
                while(i < A.length() && arrayA[i] >= '0' && arrayA[i] <= '9'){
                    temp = temp * 10 + (arrayA[i] - '0');
                    i++;
                }
                i--;
                Value.push(temp);
            }
            else{
                if(Operator.empty()){
                    Operator.push(arrayA[i]);
                }
                else{
                    char temp1 = Operator.pop();
                    int judge = comparePriority(temp1,arrayA[i]);
                    if(judge == 1){
                        int tempA = Value.pop();
                        int tempB = Value.pop();
                        int result = computeNumber(tempB,tempA,temp1);
                        Value.push(result);
                        Operator.push(arrayA[i]);
                    }
                    if(judge == 0){
                        Operator.push(temp1);
                        Operator.push(arrayA[i]);
                    }
                    if(judge == 2){

                    }
                    if(judge == 3){
                        while(temp1 != '('){
                            int tempA = Value.pop();
                            int tempB = Value.pop();
                            int result = computeNumber(tempB,tempA,temp1);
                            Value.push(result);
                            temp1 = Operator.pop();
                        }
                    }
                    if(judge == -1){
                        System.out.println("出现栈顶有')'错误！！！");
                    }
                }
            }
        }

        while(!Operator.empty() && !Value.empty()){
            char temp1 = Operator.pop();
            int tempA = Value.pop();
            int tempB = Value.pop();
            int result = computeNumber(tempB,tempA,temp1);
            Value.push(result);
        }
        System.out.println(Value.pop());
    }
    public int computeNumber(int a,int b,char operator){
        int result;
        switch(operator){
            case '+':
                result = a+b;
                break;
            case '-':
                result = a-b;
                break;
            case '*':
                result = a*b;
                break;
            case '/':
                result = a/b;
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }
    public int comparePriority(char a,char b){
        int[][] Value = {{1,1,0,0,0,3},
                {1,1,0,0,0,3},
                {1,1,1,1,0,3},
                {1,1,1,1,0,3},
                {0,0,0,0,0,2},
                {-1,-1,-1,-1,-1,-1}};
        int i = 0;
        int j = 0;
        if(a == '+')
            i = 0;
        if(a == '-')
            i = 1;
        if(a == '*')
            i = 2;
        if(a == '/')
            i = 3;
        if(a == '(')
            i = 4;
        if(a == ')')
            i = 5;

        if(b == '+')
            j = 0;
        if(b == '-')
            j = 1;
        if(b == '*')
            j = 2;
        if(b == '/')
            j = 3;
        if(b == '(')
            j = 4;
        if(b == ')')
            j = 5;
        return Value[i][j];
    }

    public static void main(String[] args){
        Calculation test = new Calculation();
        Scanner in = new Scanner(System.in);
        String A = in.nextLine();
        test.getExpressionValue(A);
    }

}
