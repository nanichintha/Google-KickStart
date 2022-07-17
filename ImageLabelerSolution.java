import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImageLabelerSolution {
	
	public static void main(String[] args) {
		
		Scanner SC = new Scanner(System.in);
		int T = SC.nextInt();
		
		for(int i=1; i<=T; i++) {
			
			int N = SC.nextInt();
			int M = SC.nextInt();
			List<Integer> InputList = new ArrayList<Integer>();
			List<Integer> InputList1 = new ArrayList<Integer>();
			for(int j=0; j<N; j++) {
				int num = SC.nextInt();
				InputList.add(num);
			}
			
			Collections.sort(InputList, Collections.reverseOrder());
			
			List<List<Integer>> Categorised = new ArrayList<List<Integer>>(); 
			
			for(int k=0; k<M-1; k++) {
				List<Integer> NewList = new ArrayList<>();
				NewList.add(InputList.get(k));
				Categorised.add(NewList);
				
			}
			
			for(int k=0; k<InputList.size(); k++) {
				InputList1.add(InputList.get(k));
			}
					
			for(int j=0; j<M-1; j++) {
				InputList1.remove(0);
			}
			
			//System.out.println(InputList1);
			//System.out.println(InputList);
			//System.out.println(Categorised);
			
			double median = 0;
			Collections.sort(InputList1);
			
			if(Categorised.size() == 0) {
				InputList1 = InputList;
			}
			
			if(InputList1.size()%2 == 0){
				median = ((double) InputList1.get(InputList1.size()/2) + (double) InputList1.get(InputList1.size()/2 - 1 ))/2;
			}
			else {
				median = (double) InputList1.get((int) Math.floor(InputList1.size()/2));
			}
			
//			System.out.println(median);
			
			double sum = 0;
			for(int j=0; j<Categorised.size(); j++) {
				List<Integer> NewList = Categorised.get(j);
				for(int k=0; k<NewList.size(); k++) {
					sum+=NewList.get(k);
				}
			}
			
			double result = 0;
			result = sum+median;
			
			System.out.printf("Case #%d: %.2f", i, result);
			System.out.println();
			
		}
		
	}

}