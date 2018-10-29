import LoginActionThing.LoginActionListener;

import java.awt.*;
import javax.swing.*;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JOptionPane;//消息提示框


class fouroperation extends JFrame implements ActionListener{
        JMenuBar menubar = new JMenuBar();
        JMenu LoginMenu = new JMenu("系统登录");
        JMenu UserMangeMenu = new JMenu("用户管理");
        JMenu backColorMenu = new JMenu("背景功能");
        JMenu HelpMenu = new JMenu("关于");

    JTextField titlenumber;//提示输入的个数
    JTextField  t;//随机题目
    JTextField useranswer;//用于输入答案
    JTextField rightOflase;//判断对错
    JTextField ShowTime;//显示时间
    JTextField settingtime;//设置时间
    private Timer tmr;
    JLabel L1;//标签1-6
    JLabel L2;
    JLabel L3;
    JLabel L4;
    JLabel L5;
    JLabel L6;
    JButton Btn1, btn2,btn3,colorchangebtn;
   public static JPanel p1;
    public JPanel p2;
    public JPanel p3;//面板容器
    String parten="0.00";//设置格式为“0.00”
    DecimalFormat decimal=new DecimalFormat(parten);//数字进行快速格式化，取2位小数
    String str;
    double seconds;//时间“秒”
    long startTime,endTime;
    char[]ch={'+','-','*','÷'};//存放加减乘除的符号数组
    float answer =0;//程序判断的答案
    int usertitlenumber;//用户输入的题目
    int count=0;//已经 出的题目
    int right=0;//计算答对的题目数
    int wrong=0;//计算答错的题目数
    fouroperation()
    {
        super("郑达、谢斌揆java简单四则运算");


        //添加菜单项至菜单上

        JMenuItem userLoginMenu= new JMenuItem("用户登录");
        userLoginMenu.addActionListener(new LoginActionListener());
        JMenuItem exitLoginMenu= new JMenuItem("退出");
       // JMenuItem myBackgroudColor=new JMenuItem("背景颜色改变");



        exitLoginMenu.addActionListener(new exitmyitem());
        LoginMenu.add(userLoginMenu);
        LoginMenu.add(exitLoginMenu);
       // backColorMenu.add(myBackgroudColor);
        menubar.add(LoginMenu);
        menubar.add(UserMangeMenu);
        menubar.add(backColorMenu);
        menubar.add(HelpMenu);
        //将菜单加入至菜单栏






        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//建立窗口，不能放大
        this.setSize(400,350);//窗口大小
        L1=new JLabel("输入选择题(不能超过5个)：");
        L2=new JLabel("时间：");
        L3=new JLabel("设置时间(时间不超过120秒)：");//设置时间提示
        L4=new JLabel("随机题目：");//显示题目
        L5=new JLabel("输入答案：");
        L6=new JLabel("判断对错：");
        titlenumber =new JTextField(15);
        Btn1 =new JButton("开始");
        colorchangebtn=new JButton("背景颜色改变");
        colorchangebtn.addActionListener(this);
        t=new JTextField(20);
        useranswer =new JTextField(25);
        useranswer.addActionListener(this);
        rightOflase =new JTextField(25);
        ShowTime =new JTextField(15);
        ShowTime.addActionListener(this);
        settingtime =new JTextField(5);
        settingtime.addActionListener(this);
        Timer timertask = new Timer(1000, this);//间隔1秒
        this.tmr = timertask;//添加时间
        btn3 =new JButton("提交答案");
        btn3.addActionListener(this);
        btn2 =new JButton("下一题");
        btn2.addActionListener(this);
        titlenumber.addActionListener(this);
        Btn1.addActionListener(this);
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        getContentPane().add(p1,"North");
        getContentPane().add(p2,"Center");
        getContentPane().add(p3,"South");
        p1.add(colorchangebtn);
        p1.add(menubar);

        p2.add(L3);
        p2.add(settingtime);p2.add(L1);p2.add(titlenumber);p2.add(Btn1);
        p2.add(L4);p2.add(t);p2.add(L5);p2.add(useranswer);p2.add(L6);p2.add(rightOflase);
        p3.add(L2);p3.add(ShowTime);p3.add(btn3);p3.add(btn2);
        this.setResizable(false);//设置不可以改变大小


        this.setVisible(true);//设置窗口可见
    }

static boolean colorchange=true;

    public void actionPerformed(ActionEvent e)//这是一个事件监听器，处理单击鼠标时触发的事件
    {

        if(e.getSource()==colorchangebtn)
        {
            if (colorchange==true) {
                p1.setBackground(Color.red);
                p2.setBackground(Color.red);
                colorchange=false;
            }
            else
            {
                p1.setBackground(Color.white);
                p2.setBackground(Color.white);
                colorchange=true;
            }
        }

        if(e.getSource()== Btn1)//当获取的资源是按钮1时
        {
            try
            {
                ShowTime.setText(String.valueOf(settingtime.getText()));//在显示时间框里显示以获取的时间

                int n1=120,n2=5;
                if(n1<(Integer.parseInt(ShowTime.getText())))
                {//当设置时间超过120秒，弹出对话框
                    JOptionPane.showMessageDialog(null, "时间不能超过120秒！");
                    this.setVisible(false);
                }
                if(n2<(Integer.parseInt(titlenumber.getText())))
                {//当选择题目个数超过5个，弹出对话框
                    JOptionPane.showMessageDialog(null, "选择题数不能超过5个！");
                    this.setVisible(false);

                }
                tmr.start();//开始计时

            }
            catch(NullPointerException o)
            {
               System.out.print("输入有误");
            }
            randomfouroperation();//调用产生随机数题目
            //    startTime= System.currentTimeMillis(); //获取开始时间
            ShowTime.setText(String.valueOf(settingtime.getText()));
        }
        else{
            int m = Integer.parseInt(ShowTime.getText());
            m--;
            ShowTime.setText("" + m);
            if (m <= 0)
            {
                tmr.stop();
                JOptionPane.showMessageDialog(null, "超出答题时间！");
                this.setVisible(false);
            }


            if(e.getSource()==menubar.getMenu(1))
            {

            }
            else if(e.getSource()==btn3)
            {
                str=decimal.format(answer);
                if(Float.parseFloat(str)==Float.parseFloat(useranswer.getText()))//判断输入的答案对错
                {
                    right++;
                    rightOflase.setText("输入的答案正确!");
                    rightOflase.setForeground(Color.red);
                }
                else
                {
                    wrong++;
                    rightOflase.setText("输入的答案不正确!正确答案为"+Float.parseFloat(str));
                    rightOflase.setForeground(Color.red);//当判断答案对错时，字体显示红色
                }
            }
            else if(e.getSource()== btn2)//当获取的资源是按钮2
            {
                str=decimal.format(answer);

                count++;//当未超过题目数时，继续出随机题
                if(count!=Integer.parseInt(titlenumber.getText()))
                {
                    t.setText(null);
                    useranswer.setText(null);
                    rightOflase.setText(null);
                    randomfouroperation();
                }

                else
                {//当超过输入的题目数时，弹出结束的消息框


                    tmr.stop();

                    //double endTime= System.currentTimeMillis() ;//获取结束时间
                    seconds=Double.parseDouble(settingtime.getText())-Double.parseDouble(ShowTime.getText());//计算时间
                    //ShowTime.setText(String.valueOf(seconds)+"s");//输出时间
                    JOptionPane.showMessageDialog(null, "答题结束!一共答对"+right+"道题目,答错"+wrong+"道题目!"+"答题时间为："+seconds+"秒");
                    this.setVisible(false);
                }
            }

        }
    }
    private void randomfouroperation()//随机产生运算
    {
        int x=(int)(Math.random()*5);
        switch(x)
        {
            case 0:
                function1();//一个运算符，整数，整数
                break;
            case 1:
                function2();//一个运算符，整数，分数
                break;
            case 2:
                function3();//一个运算符，分数，分数
                break;
            case 3:
                function4();//两个运算符
                break;
            case 4:
                function5();//求阶乘
                break;
            case 5:
                function6();//题目出现负数
                break;

        }
    }
    private void function1()//整数一个运算符
    {
        int a=(int)(Math.random()*10+1);
        int b=(int)(Math.random()*10+1);
        int x1=(int)(Math.random()*4);//表示加减乘除
        switch(x1)
        {
            case 0:
            {
                t.setText(a+" "+String.valueOf(ch[0])+" "+b);
                answer =a+b;
            }
            break;
            case 1:
            {
                t.setText(a+" "+String.valueOf(ch[1])+" "+b);
                answer =a-b;
            }
            break;
            case 2:
            {
                t.setText(a+" "+String.valueOf(ch[2])+" "+b);
                answer =a*b;
            }
            break;
            case 3:
            {
                t.setText(a+" "+String.valueOf(ch[3])+" "+b);
                answer =(float)a/(float)b;
            }
            break;
        }
    }
    private void function2()//整数和分数一个运算符
    {
        int a=(int)(Math.random()*10+1);
        int b=(int)(Math.random()*10+1);
        int c=(int)(Math.random()*10+1);
        int x1=(int)(Math.random()*4);//表示加减乘除
        switch(x1)
        {
            case 0:
            {
                t.setText(a+" "+String.valueOf(ch[0])+" "+b+"/"+c);
                answer =a+((float)b/(float)c);
            }break;
            case 1:
            {
                t.setText(a+" "+String.valueOf(ch[1])+" "+b+"/"+c);
                answer =a-((float)b/(float)c);
            }break;
            case 2:
            {
                t.setText(a+" "+String.valueOf(ch[2])+" "+b+"/"+c);
                answer =a*((float)b/(float)c);
            }break;
            case 3:
            {
                t.setText(a+" "+String.valueOf(ch[3])+" "+b+"/"+c);
                answer =(float)a/(float)b/(float)c;
            }break;
        }
    }
    private void function3()//分数一个算符
    {
        int a=(int)(Math.random()*10+1);
        int b=(int)(Math.random()*10+1);
        int c=(int)(Math.random()*10+1);
        int d=(int)(Math.random()*10+1);
        int x1=(int)(Math.random()*4);//表示加减乘除
        switch(x1)
        {
            case 0:
            {
                t.setText(a+"/"+d+" "+String.valueOf(ch[0])+" "+b+"/"+c);
                answer =((float)a/(float)d)+((float)b/(float)c);
            }break;
            case 1:
            {
                t.setText(a+"/"+d+" "+String.valueOf(ch[1])+" "+b+"/"+c);
                answer =((float)a/(float)d)-((float)b/(float)c);
            }break;
            case 2:
            {
                t.setText(a+"/"+d+" "+String.valueOf(ch[2])+" "+b+"/"+c);
                answer =((float)a/(float)d)*((float)b/(float)c);
            }break;
            case 3:
            {
                t.setText(a+"/"+d+" "+String.valueOf(ch[3])+" "+b+"/"+c);
                answer =((float)a/(float)d)/((float)b/(float)c);
            }break;
        }
    }
    private void function4()//两个运算符
    {
        int a=(int)(Math.random()*10+1);
        int b=(int)(Math.random()*10+1);
        int c=(int)(Math.random()*10+1);
        int x1=(int)(Math.random()*3);//表示加减乘除
        switch(x1)
        {
            case 0:
                fun41();//两个运算符，三个整数
                break;
            case 1:
                fun42();//两个运算符，两个整数，一个分数
                break;
            case 2:
                fun43();//两个运算符，一个整数，两个分数
                break;

        }
    }
    private void fun41()
    {
        int a=(int)(Math.random()*10+1);
        int b=(int)(Math.random()*10+1);
        int c=(int)(Math.random()*10+1);
        int x1=(int)(Math.random()*11);//表示加减乘除
        switch(x1)
        {
            case 0:
            {
                t.setText(a+" "+String.valueOf(ch[0])+" "+b+" "+String.valueOf(ch[0])+" "+c);
                answer =a+b+c;
            }break;
            case 1:
            {
                t.setText(a+" "+String.valueOf(ch[0])+" "+b+" "+String.valueOf(ch[1])+" "+c);
                answer =a+b-c;
            }break;
            case 2:
            {
                t.setText(a+" "+String.valueOf(ch[1])+" "+b+" "+String.valueOf(ch[1])+" "+c);
                answer =a-b-c;
            }break;
            case 3:
            {
                t.setText(a+" "+String.valueOf(ch[2])+" "+b+" "+String.valueOf(ch[0])+" "+c);
                answer =a*b+c;
            }break;
            case 4:
            {
                t.setText(a+" "+String.valueOf(ch[2])+" "+b+" "+String.valueOf(ch[1])+" "+c);
                answer =a*b-c;
            }break;
            case 5:
            {
                t.setText(a+" "+String.valueOf(ch[2])+" "+b+" "+String.valueOf(ch[2])+" "+c);
                answer =a*b*c;
            }break;
            case 6:
            {
                t.setText(a+" "+String.valueOf(ch[0])+" "+b+" "+String.valueOf(ch[1])+" "+c);
                answer =a+b-c;
            }break;
            case 7:
            {
                t.setText(a+" "+String.valueOf(ch[3])+" "+b+" "+String.valueOf(ch[0])+" "+c);
                answer =((float)a/(float)b)+c;
            }break;
            case 8:
            {
                t.setText(a+" "+String.valueOf(ch[3])+" "+b+" "+String.valueOf(ch[1])+" "+c);
                answer =((float)a/(float)b)-c;
            }break;
            case 9:
            {
                t.setText(a+" "+String.valueOf(ch[3])+" "+b+" "+String.valueOf(ch[3])+" "+c);
                answer =((float)a/(float)b)/(float)c;
            }break;
        }
    }
    private void fun42()
    {
        int a=(int)(Math.random()*10+1);
        int b=(int)(Math.random()*10+1);
        int c=(int)(Math.random()*10+1);
        int d=(int)(Math.random()*10+1);
        int x1=(int)(Math.random()*4);//表示加减乘除
        switch(x1)
        {
            case 0:
            {
                t.setText(a+"/"+d+" "+String.valueOf(ch[0])+b+" "+String.valueOf(ch[0])+" "+c);
                answer =((float)a/(float)d)+b+c;
            }break;
            case 1:
            {
                t.setText(a+"/"+d+" "+String.valueOf(ch[0])+b+" "+String.valueOf(ch[1])+" "+c);
                answer =((float)a/(float)d)+b-c;
            }break;
            case 2:
            {
                t.setText(a+"/"+d+" "+String.valueOf(ch[1])+b+" "+String.valueOf(ch[1])+" "+c);
                answer =((float)a/(float)d)-b-c;
            }break;
            case 3:
            {
                t.setText(a+"/"+d+" "+String.valueOf(ch[2])+b+" "+String.valueOf(ch[0])+" "+c);
                answer =((float)a/(float)d)*b+c;
            }break;
            case 4:
            {
                t.setText(a+"/"+d+" "+String.valueOf(ch[2])+b+" "+String.valueOf(ch[1])+" "+c);
                answer =((float)a/(float)d)*b-c;
            }break;
            case 5:
            {
                t.setText(a+"/"+d+" "+String.valueOf(ch[2])+b+" "+String.valueOf(ch[2])+" "+c);
                answer =((float)a/(float)d)*b*c;
            }break;
            case 6:
            {
                t.setText(a+"/"+d+" "+String.valueOf(ch[2])+b+" "+String.valueOf(ch[3])+" "+c);
                answer =((float)a/(float)d)*b/(float)c;
            }
            case 7:
            {
                t.setText(a+"/"+d+" "+String.valueOf(ch[3])+b+" "+String.valueOf(ch[0])+" "+c);
                answer =((float)a/(float)d)/(float)b+c;
            }break;
            case 8:
            {
                t.setText(a+"/"+d+" "+String.valueOf(ch[3])+b+" "+String.valueOf(ch[1])+" "+c);
                answer =((float)a/(float)d)/(float)b-c;
            }break;
            case 9:
            {
                t.setText(a+"/"+d+" "+String.valueOf(ch[3])+b+" "+String.valueOf(ch[3])+" "+c);
                answer =((float)a/(float)d)/(float)b/(float)c;
            }break;
        }
    }
    private void fun43()//一个整数，两个分数
    {
        int a=(int)(Math.random()*10+1);
        int b=(int)(Math.random()*10+1);
        int c=(int)(Math.random()*10+1);
        int d=(int)(Math.random()*10+1);
        int e=(int)(Math.random()*10+1);
        int x1=(int)(Math.random()*4);//表示加减乘除
        switch(x1)
        {
            case 0:
            {
                t.setText(a+"/"+d+" "+String.valueOf(ch[0])+" "+b+"/"+c+" "+String.valueOf(ch[0])+" "+e);
                answer =((float)a/(float)d)+((float)b/(float)c)+e;
            }break;
            case 1:
            {
                t.setText(a+"/"+d+" "+String.valueOf(ch[0])+" "+b+"/"+c+" "+String.valueOf(ch[1])+" "+e);
                answer =((float)a/(float)d)+((float)b/(float)c)-e;
            }break;
            case 2:
            {
                t.setText(a+"/"+d+" "+String.valueOf(ch[1])+" "+b+"/"+c+" "+String.valueOf(ch[1])+" "+e);
                answer =((float)a/(float)d)-((float)b/(float)c)-e;
            }break;
            case 3:
            {
                t.setText(a+"/"+d+" "+String.valueOf(ch[2])+" "+b+"/"+c+" "+String.valueOf(ch[0])+" "+e);
                answer =((float)a/(float)d)*((float)b/(float)c)+e;
            }break;
            case 4:
            {
                t.setText(a+"/"+d+" "+String.valueOf(ch[2])+" "+b+"/"+c+" "+String.valueOf(ch[1])+" "+e);
                answer =((float)a/(float)d)*((float)b/(float)c)-e;
            }break;
            case 5:
            {
                t.setText(a+"/"+d+" "+String.valueOf(ch[2])+" "+b+"/"+c+" "+String.valueOf(ch[2])+" "+e);
                answer =((float)a/(float)d)*((float)b/(float)c)*e;
            }break;
            case 6:
            {
                t.setText(a+"/"+d+" "+String.valueOf(ch[2])+" "+b+"/"+c+" "+String.valueOf(ch[3])+" "+e);
                answer =((float)a/(float)d)*((float)b/(float)c)/(float)e;
            }
            case 7:
            {
                t.setText(a+"/"+d+" "+String.valueOf(ch[3])+" "+b+"/"+c+" "+String.valueOf(ch[0])+" "+e);
                answer =((float)a/(float)d)/((float)b/(float)c)+e;
            }break;
            case 8:
            {
                t.setText(a+"/"+d+" "+String.valueOf(ch[3])+" "+b+"/"+c+" "+String.valueOf(ch[1])+" "+e);
                answer =((float)a/(float)d)/((float)b/(float)c)-e;
            }break;
            case 9:
            {
                t.setText(a+"/"+d+" "+String.valueOf(ch[3])+" "+b+"/"+c+" "+String.valueOf(ch[3])+" "+e);
                answer =((float)a/(float)d)/((float)b/(float)c)/(float)e;
            }break;
        }
    }


    private void function5()//阶乘
    {
        int a=(int)(Math.random()*10+1);//求1~10的阶乘
        t.setText(a+"!");
        for(int i=1;i<=a;i++)
        {
            answer =1;
            answer = answer *i;
        }
    }
    private void function6()//表达式里含有负整数（负整数最小不小于-100）的题目，且负数需要带括号，用户输入的结果不用带括号。
    {
        int a=(int)(Math.random()*99+1)*-1;//随机生成-1~-99的负整数
        int b=(int)(Math.random()*10+1);
        int x1=(int)(Math.random()*4);
        switch(x1)
        {
            case 0:
            {
                t.setText("("+a+") "+String.valueOf(ch[0])+" "+b);
                answer =a+b;
            }
            break;
            case 1:
            {
                t.setText("("+a+") "+String.valueOf(ch[1])+" "+b);
                answer =a-b;
            }
            break;
            case 2:
            {
                t.setText("("+a+") "+String.valueOf(ch[2])+" "+b);
                answer =a*b;
            }
            break;
            case 3:
            {
                t.setText("("+a+") "+String.valueOf(ch[3])+" "+b);
                answer =(float)a/(float)b;
            }
            break;
        }

    }
}
class myfouroperation {
    public static void main(String[] args) {
        new fouroperation();

    }
}