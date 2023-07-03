class Waiting_Room
{
    Patient Waiting_room_queue_head;
    Scanner input=new Scanner(System.in);
    void create_patient_list(String file_name)
    {
   	 Access_database obj=new Access_database();
   	 ArrayList<String> data = obj.get_data(file_name);
   	 
   	 for(int i=1;i<=15;i++)
   	 {
   		 String n=data.get(0);
   		 int a=Integer.parseInt(data.get(1));
   		 int p=Integer.parseInt(data.get(2));
   		 String d=data.get(3);
   		 String g=data.get(4);
   		 Patient new_patient=new Patient(n,a,g,d,p);
   		 data.remove(0);
   		 data.remove(0);
   		 data.remove(0);
   		 data.remove(0);
   		 data.remove(0);
   		 
   		 
   		 if(Waiting_room_queue_head==null)
   		 {
   			 Waiting_room_queue_head=new_patient;
   		 }
   		 
   		 else if((Waiting_room_queue_head.next==null)&&(Waiting_room_queue_head.priority<new_patient.priority))
   		 {
   			 Waiting_room_queue_head.next=new_patient;
   		 }
   		 
   		 else
   		 {
   			 Patient curr=Waiting_room_queue_head;
   			 Patient prev=Waiting_room_queue_head;
   			 while((curr!=null) && (curr.priority<=new_patient.priority))
   			 {
   				 prev=curr;
   				 curr=curr.next;
   			 }
   			 if(curr==Waiting_room_queue_head)
   			 {
   				 new_patient.next=Waiting_room_queue_head;
   				 Waiting_room_queue_head=new_patient;
   			 }
   			 else
   			 {
   				 prev.next=new_patient;
   				 new_patient.next=curr;
   			 }
   		 }    
   	 }
    }
    
    void add_patient() //########add UI
    {
   	 System.out.print("Enter Patient's Full Name:- ");
   	 String n=input.next();
   	 System.out.print("Enter Patient's Age:- ");
   	 int a=input.nextInt();
   	 System.out.print("Enter Patient's Gender:- ");
   	 String g=input.next();
   	 System.out.print("Enter Symptoms:- ");
   	 String d=input.next();
   	 int p=give_priority_patients(d);
   	 
   	 Patient new_patient=new Patient(n,a,g,d,p);
   	 
   	 
   	 if(Waiting_room_queue_head==null)
   	 {
   		 Waiting_room_queue_head=new_patient;
   	 }
   	 
   	 else if((Waiting_room_queue_head.next==null)&&(Waiting_room_queue_head.priority<new_patient.priority))
   	 {
   		 Waiting_room_queue_head.next=new_patient;
   	 }
   	 
   	 else
   	 {
   		 Patient curr=Waiting_room_queue_head;
   		 Patient prev=Waiting_room_queue_head;
   		 while((curr!=null) && (curr.priority<=new_patient.priority))
   		 {
   			 prev=curr;
   			 curr=curr.next;
   		 }
   		 if(curr==Waiting_room_queue_head)
   		 {
   			 new_patient.next=Waiting_room_queue_head;
   			 Waiting_room_queue_head=new_patient;
   		 }
   		 else
   		 {
   			 prev.next=new_patient;
   			 new_patient.next=curr;
   		 }
   	 }    
    }
    
    int give_priority_patients(String disease)
    {
   	 switch(disease)
   	 {
   	 case "Stroke":
   		 return 1;
   		 
   	 case "Accident":
   		 return 2;
   	 
   	 case "Heart Attack":
   		 return 3;
   		 
   	 case "Organ Failure":
   		 return 4;
   		 
   	 case "Asthama Attack":
   		 return 5;
   		 
   	 case "Severe Allergic Reaction":
   		 return 6;
   		 
   	 case "Chest Trauma":
   		 return 7;
   		 
   	 case "Pregnancy":
   		 return 8;
   		 
   	 case "Poisoning":
   		 return 9;
   		 
   	 case "Pnuemonia":
   		 return 10;
   		 
   	 case "Fracture":
   		 return 11;
   		 
   	 case "Animal Injury":
   		 return 12;
   	 
   	 }
   	 return 0;
    }
    
    void print_patients_in_waiting_room()//########add UI

    {
   	 Patient ptr=Waiting_room_queue_head;
   	 if(Waiting_room_queue_head==null)
   	 {
   		 return;
   	 }
   	 else
   	 {
   		System.out.println("--------------------------------------------------------------------------------");
        System.out.println("                     **** PATIENTS IN THE WAITING ROOM **** ");
        System.out.println("--------------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println(" NAME    \t\t\tAGE   \t\tDISEASE  \t\tGENDER");
		System.out.println("--------------------------------------------------------------------------------");
   		 while(ptr!=null)
   		 {
   			System.out.println( ptr.Name + "\t\t\t" + ptr.Age + "\t\t" + ptr.Disease + "\t\t" + ptr.Gender);	 
   			 ptr=ptr.next;
   		 }
   		 
   	 }
    }
    
    Patient admit_patient_to_ER()
    {
   	 if(Waiting_room_queue_head==null)
   	 {
   		 System.out.println("\n Currently No Patients in Waiting Room!! ");
   		 return null;
   	 }
   	 else
   	 {
   		 Patient admit=Waiting_room_queue_head;
   		 Waiting_room_queue_head=Waiting_room_queue_head.next;
   		 admit.next=null;
   		 return admit;
   		 
   	 }
    }
}
