public class Main
{
    public static void main(String[] args)
    {
    
   	 Waiting_Room obj1=new Waiting_Room();
   	 obj1.create_patient_list("Patient List.csv");
   	 //used csv files instead of database for fetching the initial data
   	 
   	 Physician_Data obj2=new Physician_Data();
   	 obj2.doctor_list("Doctors list.csv");
   	 
   	 
   	 Lab_Data obj3=new Lab_Data();
   	 obj3.Lab_facilities("Laboratory List.csv");
   	 
   	 Emergency_Room obj4=new Emergency_Room();
   	Ambulance d=new Ambulance();
    int g[][]=new int [][] { {-1,3,-1,-1,-1,-1,-1,7,-1},
    {3,-1,7,-1,-1,-1,-1,10,4},
    {-1,7,-1,6,-1,2,-1,-1,1},
    {-1,-1,6,-1,8,13,-1,-1,3},
    {-1,-1,-1,8,-1,9,-1,-1,-1},
    {-1,-1,2,13,9,-1,4,-1,5},
    {-1,-1,-1,-1,-1,4,-1,2,5},
    {7,10,-1,-1,-1,-1,2,-1,6},
    {-1,4,1,3,-1,5,5,6,-1}
    };
   
   	 
   	 Scanner sc=new Scanner (System.in);
       	 
    	int cont=1;
    	System.out.println("--------------------------------------------------------------------------------");
		System.out.println("**** # EMERGENCY HEALTH CARE SYSTEM # ****");
    	System.out.println("--------------------------------------------------------------------------------");
    	while(cont==1)
    	{
        	System.out.println("    	*** MENU ***				");
        	System.out.println("1)Add a New Patient to the waiting room");
        	System.out.println("2)Admit patient ");
        	System.out.println("3)Print list of patients in Waiting Room");
        	System.out.println("4)Print list of patients in Emergency Room");
        	System.out.println("5)Search Doctor by Specialization");
        	System.out.println("6)Display all doctors");
        	System.out.println("7)Display available Laboratory Facilities");
        	System.out.println("8)Shortest Path from Hospital to Emergency Places");
       	
       	 
        	System.out.print("\nSelect option from menu: ");
        	int choice=sc.nextInt();
        	System.out.print("\n");
       	 
        	switch(choice)
        	{
            	case 1:
           		 obj1.add_patient();
            	break;
           	 
            	case 2:
           		 obj4.admit_patient(obj1.admit_patient_to_ER());    
            	break;
           	 
           	 
            	case 3:
           		 obj1.print_patients_in_waiting_room();
            	break;
           	 
           	 
            	case 4:
           		 obj4.display_admitted_patients();
            	break;
           	 

            	case 5:
           		 System.out.println("1)Cardiologist");
           		 System.out.println("2)Neurologist");
           		 System.out.println("3)Emergency Room Physician");
           		 System.out.println("4)Surgeon");
           		 System.out.println("5)Ophthalmologist");
           		 System.out.println("6)Gynecologist");
           		 System.out.println("7)Dermatologist");
           	 
           		 
           		 System.out.println("Enter specialization needed: ");
           		 String sp=sc.next();
           		 obj2.doctor_by_specialization(sp);
            	break;
           	 
           	 
            	case 6:
           		 obj2.print_all_doctors();
            	break;
           	 
           	 
            	case 7:
           		 obj3.print_Lab_facilities();
            	break;
            	
            	case 8:
            	d.Dijiktras(g, 0);
           	  break;
           	 
            	default:
            	System.out.println("\nPlease enter a valid choice!!");
        	}
       	 
        	System.out.println("");
        	System.out.print("\nPress 1 to continue or zero to exit: ");
        	cont=sc.nextInt();
    	}
    	sc.close();
   	    	 
   	 
    }
}

//////////////////////////////////////////////////////////////////////////////

class Patient
{
    String Name,Gender,Disease;
    int Age,priority;
    Patient next;
    
    Patient(String Name,int Age,String Gender,String Disease,int priority)
    {
   	 this.Name=Name;
   	 this.Age=Age;
   	 this.Gender=Gender;
   	 this.Disease=Disease;
   	 this.priority=priority;
   	 next=null;
    }
}

/////////////////////////////////////////////////////////////////////
class Doctor
{
    String Name,Qualification,Gender,Specialization,Disease;
    Doctor next;
    
    Doctor(String Name,String Qualification,String Gender,String Specialization,String Disease)
    {
   	 this.Name=Name;
   	 this.Qualification=Qualification;
   	 this.Gender=Gender;
   	 this.Specialization=Specialization;
   	 this.Disease=Disease;
   	 next=null;
    }
}

//////////////////////////////////////////////////////////////////////////////
class Laboratory
{
    String Lab_name,Incharge_name,Facilities;
    Laboratory next;
    
    Laboratory(String Lab_name,String Incharge_name,String Facilities)
    {
   	 this.Lab_name=Lab_name;
   	 this.Incharge_name=Incharge_name;
   	 this.Facilities=Facilities;
   	 next=null;
    }
}
////////////////////////////////////////////////////////////////////////
class Access_database
{
    public String convertToCSV(String[] data)
    {
    	return Stream.of(data).collect(Collectors.joining(","));
    }
    
   	 
    ArrayList<String> get_data(String f)
    {
   	 ArrayList<String> data = new ArrayList<String>();
   	 try
   	 {
   		 Scanner sc=new Scanner(new File(f));
   		 sc.useDelimiter(",");
   		 while(sc.hasNext())
   		 {
   			 data.add(sc.next());
   		 }
   		 
   	 }
   	 catch (FileNotFoundException e1)
   	 {
   		 // TODO Auto-generated catch block
   	 }
   	 
   	 
   	 return data;
    }
}
/////////////////////////////////////////////////////////////////////////////

