import java.io.*;
import java.util.Scanner;
class excute
{   int a[][]=new int[50][50];
    int b[][]=new int[50][50];
    void  accept(int k_mean,int n,int b[])
    {
        int i,z=0,j,max	=(n/2)+1;
        for(i=0;i<k_mean;i++)
        {
            for(j=0;j<max;j++)
            {
                a[i][j]=b[z]; z++;
                if(z>=n)
                { break;}
            }
        }
        printmatrix(k_mean,max,a);
        pre_calculate(k_mean,n,max,a);
    }
    void pre_calculate(int k_mean,int n,int max,int a[][])
    {
        int count[]=new int[k_mean];
        int mean[]=new int[k_mean];
		int distance[]=new int[k_mean];
		int i,j,z=0,temp=0,index;
		for(i=0;i<k_mean;i++)
        {
            for(j=0;j<max;j++)
            {
                if(a[i][j]!=0)
				{ z++; }
				count[i]=z;
            }
			z=0;
        }
		System.out.println("count[]");
		printarray(k_mean,count);
		for(i=0;i<k_mean;i++)
        {
            for(j=0;j<max;j++)
            {
                if(a[i][j]!=0)
				{ temp=temp+a[i][j]; }
	
            }
			mean[i]=temp/count[i];
			temp=0;
        }
		System.out.println("mean[]");
		printarray(k_mean,mean);
		for(i=0;i<k_mean;i++)
        {
            for(j=0;j<max;j++)
            {
                if(a[i][j]!=0)
				{
					for(z=0;z<k_mean;z++)
					{ distance[z]=Math.abs(a[i][j]-mean[z]); }
					index=min(distance,k_mean);
					while(b[index][z]!=0)
					{ z++; }
					b[index][z]=a[i][j];
					z=0; index=0;
			    }
            }
        }
		printmatrix(k_mean,max,b);
    }
	
	
	
	
	
	
	int min(int distance[],int k_mean)
	{
		int min=distance[0],id=0;
		for(int i=1;i<k_mean;i++)
		{
			if(min>distance[i])
			{
				min=distance[i];
				id=i;
			}
		}
		return id;
	}
	
	
	void printmatrix(int k_mean,int max,int p[][])
	{
		for(int i=0;i<k_mean;i++)
        {
            for(int j=0;j<max;j++)
            {
                System.out.print(p[i][j]+" ");
            }
            System.out.println();
        }
	}
	void printarray(int max,int d[])
	{
		for(int i=0;i<max;i++)
		{ System.out.print(" "+d[i]); }
	}
}
class cluster
{
    public static void main(String a[])
    {
        excute e=new excute();
        Scanner sc=new Scanner(System.in);
        int k_mean,n;
        int b[]=new int[20];
        System.out.print("k-mean: ");
        k_mean=sc.nextInt();
        System.out.print("n: ");
        n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            System.out.print("b["+i+"] ");
            b[i]=sc.nextInt();
        }
        e.accept(k_mean,n,b);
    }
}