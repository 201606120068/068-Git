#include<stdio.h>
#include<stdlib.h>
#include<time.h>
char getSignal();                      //������������
int random(double,double);             //���������
int getResult(int,int,char);           //ͳ�ƽ��
int takeTest();                        //������Ŀ
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
		 printf("****||*********************��ӭ����֣���������������******************||****\n");
		 printf("\n");
		 printf("****||*******************************************************************||****\n");
		 printf("\n");
		 printf("****||*******************************************************************||****\n");
		 printf("\n");
		 printf("****||*******************************************************************||****\n");
         printf("\n��������Ҫ�������Ŀ������:");
         scanf("%d",&n);
         for(i=0;i<n;i++)
         {
             a=takeTest();
             right=right+a;//ͳ����ȷ����
         }      
         //printf("��ȷ��Ϊ:%d\n",right);
         percent=((double)right*100.00)/(double)n;//��ȷ��right��������n������ȷ�ʣ�ע����Ҫת����double�ͣ�
         printf("��ȷ��Ϊ:%0.2f %%\n",percent);
}
char getSignal()//��ȡ����'+','-','*','/'
{
    char signal[4]={'+','-','*','/'};
    srand((unsigned)time(NULL));//ͨ��ʱ��仯������ͬ����
    return signal[rand()%4];
}
int random(double start, double end)
{
    return (int)(start+(end-start)*rand()/(RAND_MAX+ 1.0));
}
int getResult(int num1,int num2,char signal)
{
    int res;
    switch(signal)//������ֻ�����֣�����ֱ����switch���ɣ���Ȼ��Ҳ������if...else��
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
        printf("��������\n");
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
if(signal=='-')//���ƴ𰸲���Ϊ���������num1<num2,��ͨ��temp����num1,num2
    {
        if(num1<num2)
        {
            int temp;
            temp=num1;
            num1=num2;
            num2=temp;
        }
    }
    if(signal=='/')//��������Ϊ0
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
    fflush(stdin);   //������뻺����
    if(getResult(num1,num2,signal)==get)
        {
        printf("��ϲ�㣬�ش���ȷ����ð���Ŷ!\n");
        a=1;
        }
    else
    {
        printf("���ش���󣬼�������Ŷ!\n");
        printf("��ȷ��Ϊ: %d\n",getResult(num1,num2,signal));
        a=0;
    }
    return a;
}