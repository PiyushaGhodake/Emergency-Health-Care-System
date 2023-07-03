class Ambulance{
	static final int Total_vertex=9;
	public int Min_Dist(int distance[],Boolean P[]) {
		int m=Integer.MAX_VALUE;
		int m_index=0;
		for(int i=0;i<Total_vertex;i++) {
			if(P[i] == false && distance[i]<=m) {
				m=distance[i];
				m_index=i;
			}
		}
		return m_index;
	}
	public void Display(int distance[],int n)
	{
		int xm=9,ch;
		Scanner sc =new Scanner (System.in);
		System.out.println("The shortest distance from Karve Nagar ");
		do
		{
			System.out.println("TO:");
			System.out.println(" 1.KARVENAGAR \n 2.KOTHRUD\n 3.FC ROAD \n 4.DECCAN \n 5.SHIVAJI NAGAR \n 6.WAKDEWADI \n 7.NARHE \n 8.SINHGAD ROAD \n 9.PAVILION MALL");
			System.out.println("Enter your choice ");
			ch=sc.nextInt();
			switch(ch)
			{
				case 1: System.out.println("To KARVENAGAR the shortest distance is :"+distance[0] +" km");
				break;
				case 2: System.out.println("To KOTHRUD the shortest distance is :"+distance[1]+" km");
				break;
				case 3: System.out.println("To FC ROAD the shortest distance is :"+distance[2]+" km");
				break;
				case 4: System.out.println("To DECCAN the shortest distance is :"+distance[3]+" km");
				break;
				case 5: System.out.println("To SHIVAJI NAGAR the shortest distance is :"+distance[4]+" km");
				break;
				case 6: System.out.println("To WAKDEWADI the shortest distance is :"+distance[5]+" km");
				break;
				case 7: System.out.println("To NARHE the shortest distance is :"+distance[6]+" km");
				break;
				case 8: System.out.println("To SINHAGAD ROAD the shortest distance is :"+distance[7]+" km");
				break;
				case 9: System.out.println("To PAVILION MALL the shortest distance is :"+distance[8]+" km");
				break;
                }
		}
		while(ch !=9);
		System.out.println("EXIT!");
	}
	public void Dijiktras(int graph[][],int s)
	{
		int distance[]=new int[Total_vertex];
		Boolean P[]=new Boolean[Total_vertex];
		for(int i=0;i<Total_vertex;i++)
		{
			distance[i]=Integer.MAX_VALUE;
			P[i]=false; //non visited vertex
		}
		distance[s]=0; //distance from source to itself is zero
		for(int j=0;j<Total_vertex-1;j++) {
			int u=Min_Dist(distance,P);
			P[u]=true; //now the node is visited
			for(int v=0;v<Total_vertex;v++)
				if(!P[v]&& graph[u][v]!=-1 &&
				distance[u]!=Integer.MAX_VALUE && distance[u]+graph[u][v]<distance[v] )
				{
					distance[v]=distance[u]+graph[u][v];
				}
		}
		Display(distance,Total_vertex);
	}
}
