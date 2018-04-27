import java.io.*;
import java.lang.*;
import java.util.Scanner;
public class TicTacToe
{         
    public static int chance=1;
    public static int check=1;
    public static String X;
    public static String O;
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String array[][]=new String[3][3];
        int i,j;
        TicTacToe obj=new TicTacToe();
         String first[][]=new String[1][2];
         String second[][]=new String[1][2];  
         
        for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            {
               array[i][j]=".";
            }
        }
        System.out.println("Enter the name of the X player");
        X=sc.nextLine();
        System.out.println("Enter the name of the O Player");
        O=sc.nextLine();
        
         System.out.println("X is "+X);
         System.out.println("O is "+O);
         obj.whoGoesFirst(first,second,X,O);
         obj.whosechance(chance,X,O,first,second,array);
    }
     void whoGoesFirst(String first[][],String second[][],String X,String O)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Who will go first,"+X+" or "+O);
        String bb=sc.next();
        if(bb.equalsIgnoreCase(X))
        {
            first[0][0]=X;
            first[0][1]="X";
            second[0][0]=O;
            second[0][1]="O";
        }
        else if(bb.equalsIgnoreCase(O))
        {
             first[0][0]=O;
             first[0][1]="O";
             second[0][0]=X;
             second[0][1]="X";
        } 
        else
        {
             System.out.println(bb+" is not a registered name.");
             System.out.println("Please enter the name again ");
             whoGoesFirst(first,second,X,O);
        }
    }
     void whosechance(int chance,String X,String O,String first[][],String second[][],String array[][])
    {
         if(chance%2!=0)
         {
             System.out.println("Its "+first[0][0]+"'s chance.");
             row(array,first,second,X,O,chance);
         }
         else
         {
              System.out.println("Its "+second[0][0]+" 's chance. ");
              row(array,first,second,X,O,chance);
         }
    }          
    void row(String array[][],String first[][],String second[][],String X,String O,int chance)
    {
          Scanner sc=new Scanner(System.in);
          System.out.println("Enter row number from 0 to 2 ");
          int row_value=sc.nextInt();
          if(row_value>=0 && row_value<=2)
          {
              col(row_value,array,first,second,X,O,chance);
          }
          else
          {
              System.out.println("Wrong input.");
              System.out.println("Enter again. ");
              row(array,first,second,X,O,chance);
          }
    }
    void col(int row_value,String array[][],String first[][],String second[][],String X,String O,int chance)
    {
          Scanner sc=new Scanner(System.in);
          System.out.println("Enter column number from 0 to 2 ");
          int col_value=sc.nextInt();
          if(col_value>=0 && col_value<=2)
          {
                int check=flag(row_value,col_value,array);
                if(check==0)
                    {
                        savetoarray(first,second,X,O,row_value,col_value,array,chance);
                    }
                    else
                    {
                        System.out.println("That place is already taken.");
                        System.out.println("Enter again ");
                        row(array,first,second,X,O,chance);
                    }
          }
          else
          {
                 System.out.println("Wrong input.");
                 System.out.println("Enter again. ");
                 System.out.println(row_value);
                 col(row_value,array,first,second,X,O,chance);
          }
    }
    int flag(int row_value,int col_value,String array[][])
    {
         if(array[row_value][col_value]=="X"|| array[row_value][col_value]=="O")
         {
                 return 1;
         }
         else
         {
                return 0;
         }
    }
    void savetoarray(String first[][],String second[][],String X,String O,int row_value,int col_value,String array[][],int chance)
    {
        int t; 
        if(chance%2!=0)
         {
                array[row_value][col_value]=first[0][1];
         }
         else
         {        
                array[row_value][col_value]=second[0][1];
         }
        printarray(array,X,O,first,second,chance);
        t=winner(array,X,O,first,second);
        if(t==1)
        {
             chance++;
             whosechance(chance,X,O,first,second,array);
        }
        else
        {
             playagain(first,second,X,O,array);
        }
    }
    int winner(String array[][],String X,String O,String first[][],String second[][])
    {
        int b=0;
        if(array[0][0]==(first[0][1]) && array[0][1]==(first[0][1]) && array[0][2]==(first[0][1]))
         {
             System.out.println(first[0][1]+"is the winner.");
             printarray(array,X,O,first,second,chance);
             b=0;             
         }
         else if(array[0][0]==(first[0][1]) && array[1][0]==(first[0][0]) && array[2][0]==(first[0][1]))
         {
             System.out.println(first[0][1]+"is the winner.");             
             printarray(array,X,O,first,second,chance);
              b=0;                        
         }
         else if(array[0][0]==(first[0][1]) && array[1][1]==(first[0][1]) && array[2][2]==(first[0][1]))
         {
              System.out.println(first[0][1]+"is the winner.");
              printarray(array,X,O,first,second,chance);              
              b=0;
         } 
         else if(array[0][1]==(first[0][1]) && array[1][1]==(first[0][1]) && array[2][1]==(first[0][1]))
         {
               System.out.println(first[0][1]+"is the winner.");
               printarray(array,X,O,first,second,chance);
               b=0;               
         }
         else if(array[0][2]==(first[0][1]) && array[1][1]==(first[0][1]) && array[2][0]==(first[0][1]))
         {
                System.out.println(first[0][1]+"is the winner.");
                printarray(array,X,O,first,second,chance);
                b=0;
         }
         else if(array[0][2]==(first[0][1]) && array[1][2]==(first[0][1]) && array[2][2]==(first[0][1]))
         {
                System.out.println(first[0][1]+"is the winner.");
                printarray(array,X,O,first,second,chance);
                b=0;
         }
         else if(array[1][0]==(first[0][1]) && array[1][1]==(first[0][1]) && array[1][2]==(first[0][1]))
         {
                System.out.println(first[0][1]+"is the winner.");        
                printarray(array,X,O,first,second,chance);
                b=0;
         }
         else if(array[2][0]==(first[0][1]) && array[2][1]==(first[0][1]) && array[2][2]==(first[0][1]))
         {
                System.out.println(first[0][1]+"is the winner.");
                printarray(array,X,O,first,second,chance);
                b=0;
         }                                              
         else if(array[0][0]==(second[0][1]) && array[0][1]==(second[0][1]) && array[0][2]==(second[0][1]))
         {
                System.out.println(second[0][1]+"is the winner.");             
                printarray(array,X,O,first,second,chance);
                b=0;

         }
         else if(array[0][0]==(second[0][1]) && array[1][0]==(second[0][1]) && array[2][0]==(second[0][1]))
         {
                System.out.println(second[0][1]+"is the winner.");
                printarray(array,X,O,first,second,chance);
                b=0;
         }
         else if(array[0][0]==(second[0][1]) && array[1][1]==(second[0][1]) && array[2][2]==(second[0][1]))
         {
                 System.out.println(second[0][1]+"is the winner.");
                 printarray(array,X,O,first,second,chance);
                 b=0;
        } 
         else if(array[0][1]==(second[0][1]) && array[1][1]==(second[0][1]) && array[2][1]==(second[0][1]))
         {
                 System.out.println(second[0][1]+"is the winner.");
                 printarray(array,X,O,first,second,chance);
                 b=0;
        }
         else if(array[0][2]==(second[0][1]) && array[1][1]==(second[0][1]) && array[2][0]==(second[0][1]))
         {
                  System.out.println(second[0][1]+"is the winner.");
                  printarray(array,X,O,first,second,chance);
                  b=0;
         }
         else if(array[0][2]==(second[0][1]) && array[1][2]==(second[0][1]) && array[2][2]==(second[0][1]))
         {
                   System.out.println(second[0][1]+"is the winner.");
                   printarray(array,X,O,first,second,chance);
                   b=0;
         }
         else if(array[1][0]==(second[0][1]) && array[1][1]==(second[0][1]) && array[1][2]==(second[0][1]))
         {
                   System.out.println(second[0][1]+"is the winner.");
                   printarray(array,X,O,first,second,chance);
                   b=0;                   
         }
         else if(array[2][0]==(second[0][1]) && array[2][1]==(second[0][1]) && array[2][2]==(second[0][1]))
         {
                   System.out.println(second[0][1]+"is the winner.");
                   printarray(array,X,O,first,second,chance);
                   b=0;
         }
         //this should do the work 
         else 
         {
              int aa,bb,iflag=0;
             for(aa=0;aa<3;aa++)
             {
                 for(bb=0;bb<3;bb++)
                 {
                     if(array[aa][bb]==".")
                     {
                         iflag=2;
                       }
                 }
             }
             if(iflag==0)
             {
                  System.out.println("Array is full");
                  b=2;
             }
             else
             {
                 b=1;
                }
         }
         return b;
    }         
    void printarray(String array[][],String X,String O,String first[][],String second[][],int chance)
    {
           int i,j;
           for(i=0;i<3;i++)
            {
                for(j=0;j<3;j++)
                {
                    System.out.print(array[i][j]+" ");
                
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();             
    }    
    void playagain(String first[][],String second[][],String X,String O,String array[][])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Do you want to play again");
        System.out.println("Y for Yes and N for No ");
        String s=sc.next();
        if(s.equalsIgnoreCase("Y"))
        {
            System.out.println("Enter name for the X player ");
            X=sc.next();
            System.out.println("Enter Name for the O player ");
            O=sc.next();
            first[0][0]=null;
            first[0][1]=null;
            second[0][0]=null;
            second[0][1]=null;
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    array[i][j]=".";
                }
            }
            whoGoesFirst(first,second,X,O); 
            whosechance(chance,X,O,first,second,array);
        }
        else if ( s.equalsIgnoreCase("N"))
        {
            System.out.println("Thankyou for playing");
        }
        else
        {
            System.out.println("Wrong input ");
            System.out.println("Enter again");
            playagain(first,second,X,O,array);
        }
    }
}
