class Physician_Data
{
    Doctor head;
    void doctor_list(String filename)
    {
   	 Access_database obj=new Access_database();
   	 ArrayList<String> data = obj.get_data(filename);
   	 //String Name,Qualification,Gender,Specialization,Disease;
   	 for(int i=1;i<=15;i++)
   	 {
   		 String n=data.get(0);
   		 String q=data.get(1);
   		 String g=data.get(2);
   		 String s=data.get(3);
   		 String d=data.get(4);
   		 Doctor new_doctor=new Doctor(n,q,g,s,d);
   		 data.remove(0);
   		 data.remove(0);
   		 data.remove(0);
   		 data.remove(0);
   		 data.remove(0);
   		 
   		 if(head==null)
   		 {
   			 head=new_doctor;
   		 }
   		 
   		 else
   		 {
   			 Doctor ptr=head;
   			 while(ptr.next!=null)
   			 {
   				 ptr=ptr.next;
   			 }
   			 ptr.next=new_doctor;
   			 
   		 }
   	 }
    }
    void print_all_doctors()//########add UI
    {
   	 if(head==null)
   	 {
   		 System.out.println("No Doctor Available right now");
   	 }
   	 else
   	 {
   		 Doctor ptr=head;
    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------- ");
   		 System.out.println("                 *************************************Doctor's List***************************************");
		 System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------- ");
   		 System.out.println(" Name \t\t\t   Qualification\t      Gender \t   Specification\t\t\t    Ailiments");
		 System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
   		 while(ptr!=null)
   		 {
   			 
   			/* System.out.println("Name: "+ptr.Name);
   			 System.out.println("Qualification: "+ptr.Qualification);
   			 System.out.println("Gender: "+ptr.Gender);
   			 System.out.println("Specialization: "+ptr.Specialization);
   			 System.out.println("For Ailiments: "+ptr.Disease);
   			 System.out.println("\n\n");*/
   			
   			System.out.println( ptr.Name+ "\t\t " + ptr.Qualification + "\t\t\t" +ptr.Gender + "\t\t\t" + ptr.Specialization + "\t\t\t" + ptr.Disease);
   			
   			 ptr=ptr.next;
   		 }
   	 }
   	 
    }

    
    
    void doctor_by_specialization(String specialization)
    {
   	 int flag=0;
   	 Doctor ptr=head;
   	 while(ptr!=null)
   	 {
   		 if(ptr.Specialization.equalsIgnoreCase(specialization))
   		 {
   			 flag=1;
   			 System.out.println("--------------------------------------------------------------------------------");
   			 System.out.println("Name:- "+ptr.Name);
   			 System.out.println("Qualification:- "+ptr.Qualification);
   			 System.out.println("Gender:- "+ptr.Gender);
   			 System.out.println("Specialization:- "+ptr.Specialization);
   			 System.out.println("For Ailiments:- "+ptr.Disease);
   			 System.out.println("\n");
   		 }
   		 ptr=ptr.next;
   	 }
   	 if(flag==0)
   	 {
   		 System.out.println("No Physician found for the required Specialization");
   	 }
   	 
    }
}
