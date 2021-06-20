import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[progresses.length];
        //시간 측정
        for(int i=0; i < progresses.length;i++){ 
        	int prog = progresses[i];
        	int workingTime = 0;
        	while(true){
        		if(prog >= 100) break;
        		prog += speeds[i];
        		workingTime++;  //일한 시간 입니다.
        	}
        	answer[i] = workingTime;
        }
        
        //값 확인
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0 ; i < answer.length ; i++){  //기준값 입니다.
            int origin = answer[i];
            int count = 1;
            if(origin < 0){continue;} //조사가 완료된 대상이면 건너뛰기를 합니다.
            for(int j=i+1 ; j < answer.length ; j++){  //기준값 다음의 값 입니다.
            	int compare = answer[j];
            	if(origin >= compare){
            		answer[j] = -1; //조사가 완료되었으므로 대상에서 제거 합니다.
            		count++;
            	} else {
            		break;
            	}
            }
            list.add(count);
        }        
        answer = list.stream().mapToInt(i ->i).toArray();
        return answer;
    }
}