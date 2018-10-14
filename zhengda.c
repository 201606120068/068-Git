#include<stdio.h>
#include<stdlib.h>
#include<time.h>
char getSignal();                      //产生随机运算符
int random(double,double);             //产生随机数
int getResult(int,int,char);           //统计结果
int takeTest();                        //生成题目
void main() 
{
         int i,n,a,right=0;
         double percent;
		 printf("****||*******************************************************************||****\n");
		 printf("\n");
		 printf("****||*******************************************************************||****\n");
		 printf("\n");
		 printf("****||*******************************************************************||****\n");
		 printf("\n");
		 printf("****||*********************欢迎来到郑达简单四则运算王国******************||****\n");
		 printf("\n");
		 printf("****||*******************************************************************||****\n");
		 printf("\n");
		 printf("****||*******************************************************************||****\n");
		 printf("\n");
		 printf("****||*******************************************************************||****\n");
         printf("\n请输入您要计算的题目的数量:");
         scanf("%d",&n);
         for(i=0;i<n;i++)
         {
             a=takeTest();
             right=right+a;//统计正确个数
         }      
         //printf("正确答案为:%d\n",right);
         percent=((double)right*100.00)/(double)n;//正确数right除以总数n等于正确率（注：需要转换成double型）
         printf("正确率为:%0.2f %%\n",percent);
}
char getSignal()//获取符号'+','-','*','/'
{
    char signal[4]={'+','-','*','/'};
    srand((unsigned)time(NULL));//通过时间变化产生不同符号
    return signal[rand()%4];
}
int random(double start, double end)
{
    return (int)(start+(end-start)*rand()/(RAND_MAX+ 1.0));
}
int getResult(int num1,int num2,char signal)
{
    int res;
    switch(signal)//因种类只有四种，所以直接用switch即可，当然，也可以用if...else等
    {
    case '+':
        res=num1+num2;break;
    case '-':
        res=num1-num2;break;
    case '*':
        res=num1*num2;break;
    case '/':
        res=num1/num2;break;
    default:
        printf("符号有误！\n");
    }
    return res;
}

int takeTest()
{
    int get;
    int num1,num2,a;
    char signal;

    srand((unsigned)time(NULL));
    signal=getSignal();
    num1=random(0,1000);
    num2=random(1,1000);
if(signal=='-')//控制答案不能为负数，如果num1<num2,则通过temp交换num1,num2
    {
        if(num1<num2)
        {
            int temp;
            temp=num1;
            num1=num2;
            num2=temp;
        }
    }
    if(signal=='/')//除数不能为0
    {
        if(num2==0)
        {
            int temp;
            temp=num1;
            num1=num2;
            num2=temp;
        }
    }
    printf("%d%c%d=",num1,signal,num2);
    scanf("%d",&get);
    fflush(stdin);   //清空输入缓冲区
    if(getResult(num1,num2,signal)==get)
        {
        printf("恭喜你，回答正确，你好棒棒哦!\n");
        a=1;
        }
    else
    {
        printf("额额，回答错误，继续加油哦!\n");
        printf("正确答案为: %d\n",getResult(num1,num2,signal));
        a=0;
    }
    return a;
}