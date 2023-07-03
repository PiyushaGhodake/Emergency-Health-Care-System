class Emergency_Room
{
    Patient ER_List;
    
    void admit_patient(Patient patient)
    {
   	 if(ER_List==null)
   	 {
   		 ER_List=patient;
   	 }
   	 else
   	 {
   		 Patient ptr=ER_List;
   		 while(ptr.next!=null)
   		 {
   			 ptr=ptr.next;
   		 }
   		 ptr.next=patient;
   		 
   	 }
   	 System.out.println("--------------------------------------------------------------------------------");
   	 System.out.println("Patient Admitted to Emergency Ward !!");
   	 System.out.println("Patient Name:- "+patient.Name);
   	 System.out.println("Patient Age:- "+patient.Age);
   	 
   	 System.out.println("Patient Disease:- "+patient.Disease);
   	 System.out.println("Patient Gender:- "+patient.Gender);
   	 
    }
    
    
    void display_admitted_patients()//########add UI
    {
   	 
   	 if(ER_List==null)
   	 {
   		 System.out.println("NO ADMITTED PATIENTS!!");
   	 }
   	 else
   	 {
   		Patient ptr=ER_List;
   		System.out.println("--------------------------------------------------------------------------------");
        System.out.println("                     **** ADMITTED PATIENTS LIST **** ");
        System.out.println("--------------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println(" NAME    \t\t\tAGE   \t\tDISEASE  \t\tGENDER");
		System.out.println("--------------------------------------------------------------------------------");
   		 while(ptr!=null)
   		 {
   			System.out.println( ptr.Name + "\t\t\t" + ptr.Age + "\t\t" + ptr.Disease + "\t\t" + ptr.Gender);
   			
   			 ptr.priority=0;   				 
   			 ptr=ptr.next;
   			 
   		 }
   		 
   	 }
    }
}
    
