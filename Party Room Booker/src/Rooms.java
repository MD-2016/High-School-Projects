
public class Rooms {
	int smoking = 0;
	int nonSmoking = 0;
	boolean booked[];
	
	public Rooms(int sm, int non)
	{
		booked = new boolean[sm + non];
		
		for(int index = 0; index < booked.length; index ++)
		 booked[index] = false;
		
		smoking = sm;
		nonSmoking = non;
	}
	  
	public int bookRoom(boolean Smoking)
	{
		int start = 0, end = 0, roomNumber = 0;
		if(Smoking)
		{
			end = smoking;
		}
		else
		{
			//non smoking
			start = smoking;
			end = smoking + nonSmoking;
		}
		
		for(int index = start; index < end; index++)
		{
			if (!booked[index])
			{
				booked[index] = true;
				roomNumber = index + 1;
				index = end;
			}
		}
		
		return roomNumber;
	}
}
