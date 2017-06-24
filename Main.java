import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter The Number Of Candidate: ");
		int number=input.nextInt();
		String[]arr=new String[number];
		for(int i=0;i<number;i++){
			System.out.println("Enter The name of The Candidate ["+(i+1)+"] : ");
			arr[i]=input.next();
		}
		int Voice=-1;
		int[]VoiceOfCandidate=new int[number];
		while(true){
			System.out.println("Voice for : ");
			Voice=input.nextInt();
			if(Voice!=0)
			VoiceOfCandidate[Voice-1]++;
			else break;
		}
		double[]rate=getRate(VoiceOfCandidate);
		int max=getMax(VoiceOfCandidate);
		int min=getMin(VoiceOfCandidate);
		display(max,min,arr,VoiceOfCandidate,rate);
	}

	private static void display(int max, int min, String[] arr,int[]voiceOfCandidate, double[] rate) {
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]+"\t\t"+voiceOfCandidate[i]+"\t"+rate[i]);
		System.out.println("min votes is : "+min);
		System.out.println("max vote is : "+max);
		String[]find=findFirstCandidate(arr,voiceOfCandidate,max);
		System.out.println("The First Candidate : ");
		for(String f:find)
			System.out.println(f);
	}

	private static String[] findFirstCandidate(String[] arr, int[] voiceOfCandidate,int max) {
		int number=0;
		for(int i=0;i<voiceOfCandidate.length;i++)
			if(voiceOfCandidate[i]==max)
				number++;
		int j=0;
		String ar[]=new String[number];
		for(int i=0;i<arr.length;i++)
			if(voiceOfCandidate[i]==max)
				ar[j++]=arr[i];
		return ar;
	}

	private static int getMin(int[] voiceOfCandidate) {
		int min=(int) 1e6;
		for(int i=0;i<voiceOfCandidate.length;i++)
			min=Math.min(min, voiceOfCandidate[i]);
		return min;
	}

	private static int getMax(int[] voiceOfCandidate) {
		int max=-1;
		for(int i=0;i<voiceOfCandidate.length;i++)
			max=Math.max(max, voiceOfCandidate[i]);
		return max;
	}

	private static double[] getRate(int[] voiceOfCandidate) {
		double[]rate=new double[voiceOfCandidate.length];
		int allVoices=0;
		for(int i=0;i<voiceOfCandidate.length;i++)
			allVoices+=voiceOfCandidate[i];
		for(int i=0;i<rate.length;i++)
			rate[i]=voiceOfCandidate[i]*100/allVoices;
		
	return rate;
	}

	

}
