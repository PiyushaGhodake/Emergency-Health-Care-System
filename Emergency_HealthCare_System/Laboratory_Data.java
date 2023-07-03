class Lab_Data
{
    Laboratory list;
    
    void Lab_facilities(String filename)
    {
   	 Access_database obj=new Access_database();
   	 ArrayList<String> data = obj.get_data(filename);
   	 //String Lab_name,Incharge_name,Facilities;
   	 for(int i=1;i<=7;i++)
   	 {
   		 String l=data.get(0);
   		 String n=data.get(1);
   		 String f=data.get(2);
   		 Laboratory object=new Laboratory(l,n,f);
   		 data.remove(0);
   		 data.remove(0);
   		 data.remove(0);
   		 
   		 if(list==null)
   		 {
   			 list=object;
   		 }
   		 
   		 else
   		 {
   			 Laboratory ptr=list;
   			 while(ptr.next!=null)
   			 {
   				 ptr=ptr.next;
   			 }
   			 ptr.next=object;
   			 
   		 }
   	 }
    }
    
    void print_Lab_facilities()//########add UI
    {
    if(list==null)
    {
    System.out.println("No Labs Available right now");
    }
    else
      {
      Laboratory ptr=list;
      System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------- ");
      System.out.println("                 *************************************Laboratory Facilities***************************************");
      System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------- ");
      System.out.println("Laboratory\t \t\tIncharge Of\t \t\tFacilities For");
      System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
      while(ptr!=null)
      {
          System.out.println( ptr.Lab_name+ "\t\t\t " + ptr.Incharge_name+ "\t\t\t" +ptr.Facilities);

      ptr=ptr.next;
      }
      }

    }
}
