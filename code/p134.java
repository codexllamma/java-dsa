package code;


public class p134{
    
    public static void main(String[]args){
       int[] gas = {1,2,3,4,5};
       int[] cost = {3,4,5,1,2};
       int n = gas.length;
       

       int total = 0;
       int cand_index = 0;
       for(int i=0;i<n;i++){
          
          total += gas[i] - cost[i];
          current += gas[i] - cost[i];
          
          if(current < 0){
              current = 0;
              cand_index = i+1;
              continue;
          }


       }

       if( total < 0){
           System.out.println("NO solution");

       }
       else{
           System.out.println("Solution at index:" + cand_index);
       }
       
   }
   

}

/*

int init_index_checked = 0;
int init_index = init_index_checked;

while(true){
    int index_checked = init_index_checked;
    int index = index_checked;    
    
    int gas_tank = 0;
    while(true){
       
       gas_tank += gas[index_checked];
       if(cost[index_checked] > gas_tank){
          System.out.println("Cost:" + cost[index_checked] + "is greater than gas tank " + gas_tank + " Breaking");
          init_index_checked = (index_checked + 1) % n;
          break;
       }
       else{
          System.out.println("Gas tank is: " + gas_tank + " Cost to reach is: " + cost[index_checked]);
          gas_tank -= cost[index_checked];
          index_checked = (index_checked+1) % n;
       }
       
       //return true
       if(index_checked == index){
         System.out.println("Done with the iterations for index: " + index + "That means a path exists. Breaking");
         break;
       } 
       
    }

    if(init_index_checked == init_index){
       System.out.println("Done with all the iterations.Exiting");
       break;
    }   
}


*/
