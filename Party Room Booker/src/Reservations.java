import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Reservations extends Frame implements ActionListener {
	
    Color lightred = new Color(255,90,90);
    Color lightgreen = new Color(140,215,40);
    Rooms room = new Rooms(4,4);
    
    Panel roomPanel = new Panel();
    Panel buttonPanel = new Panel();
    
    TextArea roomDisplay[] = new TextArea[9];
    Button bookButton = new Button("Book Room");
    
    Panel inputPanel = new Panel();
    Label nameLabel = new Label("Name");
    Label phoneLabel = new Label("Phone Number");
    Label numberLabel = new Label("Number in Party");
    TextField nameField = new TextField(15);
    TextField phoneField = new TextField(15);
    Choice guestNumberChoice = new Choice();
    CheckboxGroup roomOptions = new CheckboxGroup();
    Checkbox Smoking = new Checkbox("Smoking",false,roomOptions);
    Checkbox nonSmoking = new Checkbox("Non-Smoking",false,roomOptions);
    Checkbox hidden = new Checkbox("",true,roomOptions);
    
    
    public Reservations()
	{
		this.setLayout(new BorderLayout());
		roomPanel.setLayout(new GridLayout(2,4,10,10));
		buttonPanel.setLayout(new FlowLayout());
		inputPanel.setLayout(new FlowLayout());
		
		for(int index = 1; index<9; index++)
		{
			roomDisplay[index] = new TextArea(null,3,5,3);
			if(index<5)
			{
				roomDisplay[index].setText("Room " + index + " : Smoking");			}
			else
			{
				roomDisplay[index].setText("Room " + index + " : Non-Smoking");
			}
			roomDisplay[index].setEditable(false);
			roomDisplay[index].setBackground(lightgreen);
			roomPanel.add(roomDisplay[index]);
		}
		buttonPanel.add(bookButton);
		inputPanel.add(nameLabel);
		inputPanel.add(nameField);
		inputPanel.add(phoneLabel);
		inputPanel.add(phoneField);
		inputPanel.add(numberLabel);
		inputPanel.add(guestNumberChoice);
		for(int guests = 8; guests<21; guests++ )
			guestNumberChoice.add(String.valueOf(guests));
		
		
		inputPanel.add(Smoking);
		inputPanel.add(nonSmoking);
		
		
		bookButton.addActionListener(this);
		
		add(roomPanel, BorderLayout.NORTH);
		add(inputPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		 addWindowListener(
				   new WindowAdapter()
				   {
					   public void windowClosing(WindowEvent e)
					   {
						   System.exit(0);
					   }
				   }			   
				 );
				   
	   }
	    
    
    public static void main(String[] args)
    {
    	Reservations sample = new Reservations();
    	sample.setTitle("Reserve a Party Room");
    	sample.setVisible(true);
    	sample.setBounds(200,200,600,300);
    }
	
	public void actionPerformed(ActionEvent e)
	{
	   if(hidden.getState())
	   {
		   JOptionPane.showMessageDialog(null,"You must select either a smoking or non-smoking room.","Error",JOptionPane.ERROR_MESSAGE);
	   }
	   else
	   {
		    int available = room.bookRoom(Smoking.getState());
		    if(available > 0)
		    {
		    	roomDisplay[available].setBackground(lightred);
		    	roomDisplay[available].setText(roomDisplay[available].getText() + "\n" + nameField.getText() + " " + phoneField.getText() + "\nParty of " + guestNumberChoice.getSelectedItem());
		    	//clearFields();
		    }
		    else
		    {
		    	if(Smoking.getState())
		    	 JOptionPane.showMessageDialog(null, "Smoking rooms are full","Error",JOptionPane.ERROR_MESSAGE);
		    	else
		    		JOptionPane.showMessageDialog(null, "Non-Smoking rooms are full","Error",JOptionPane.ERROR_MESSAGE);
		    	hidden.setState(true);
		    }
	   }
	}
}
