import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.util.*;

public class GadgetShop implements ActionListener
{
    private JTextField modelTextField;
    private JTextField weightTextField;
    private JTextField priceTextField;
    private JTextField sizeTextField;
    private JTextField memoryTextField;

    private String aModel;
    private int aWeight;
    private double aPrice;
    private String aSize;
    private double aMemory;

    private JFrame frame;

    private Label modelLable;
    private Label priceLable;
    private Label weightLable;
    private Label sizeLable;
    private JLabel displayNumberLable;
    private JLabel phoneNumberLable;
    private JLabel durationLable;

    private JTextField modelTextbox;
    private JTextField priceTextbox;
    private JTextField weightTextbox;
    private JTextField sizeTextbox;
    private JTextField displayNumberTextbox;
    private JTextField phoneNumberTextbox;
    private JTextField durationTextbox;
    private JTextField MemoryTextbox;

    private JLabel creditlable;
    private Label MemoryLable;
    private Button addMobileButton;
    private Button addMP3Button;
    private Button makeACall;
    private Button viewAll;
    private Button clear;

    private JTextField creditTextbox;
    private JTextField memoryTextbox;

    ArrayList<Gadget> item= new ArrayList<Gadget>();

    public static void main(String arg[])
    {
        GadgetShop aGadgetShop=new GadgetShop() ;
    }

    public GadgetShop()
    {
        makeFrame();
    }

    private void makeFrame()
    {
        frame = new JFrame (" GadetShop Grid layout") ;
        Container contentPane = frame.getContentPane();
        frame.getContentPane().setBackground(new Color(204, 0, 204));

        JLabel modelLable = new JLabel( "Model:");
        JLabel priceLable = new JLabel("Price:");
        JLabel weightLable = new JLabel ( "Weight:");
        JLabel sizeLable = new JLabel ("Size:");

        modelTextbox = new JTextField(10);
        priceTextbox = new JTextField(10);
        weightTextbox = new JTextField(10);
        creditTextbox = new JTextField(10);
        sizeTextbox = new JTextField(10);

        JLabel creditlable = new JLabel("Credit:");
        JLabel MemoryLable = new JLabel ("Memory:");

        addMobileButton = new Button( "Add Mobile");
        addMobileButton.addActionListener(this);
        addMP3Button = new Button( "Add MP3");
        addMP3Button.addActionListener(this);
        makeACall = new Button ("Make a Call");
        makeACall.addActionListener(this);
        viewAll = new Button ("View All");
        viewAll.addActionListener(this);
        clear = new Button ("Clear");
        clear.addActionListener(this);
        
        makeACall.setForeground(Color.red);
        makeACall.setBackground(Color.green);
        addMobileButton.setForeground(Color.red);
        addMobileButton.setBackground(Color.green);
        addMP3Button.setForeground(Color.red);
        addMP3Button.setBackground(Color.green);
        viewAll.setForeground(Color.red);
        viewAll.setBackground(Color.green);
         clear.setForeground(Color.red);
        clear.setBackground(Color.green);
      
        //creditTextbox = new JTextField(10);
        memoryTextbox = new JTextField(10);
        JLabel displayNumberLable = new JLabel("Display...");
        displayNumberTextbox = new JTextField(10);

        JLabel phoneNumberLable = new JLabel("Phone Number...");
        phoneNumberTextbox = new JTextField(10);
        JLabel durationLable = new JLabel ("Duration:");
        durationTextbox = new JTextField(10);

        contentPane. setLayout (new GridLayout(5, 4));

        contentPane.add(modelLable);
        contentPane.add(modelTextbox);
        contentPane.add(priceLable);
        contentPane.add(priceTextbox);
        contentPane.add (weightLable);
        contentPane.add (weightTextbox);
        contentPane.add(sizeLable);
        contentPane.add(sizeTextbox);

        contentPane.add(creditlable);
        contentPane.add(creditTextbox);
        contentPane.add(MemoryLable);
        contentPane.add(memoryTextbox);

        contentPane.add (Box.createHorizontalGlue());
        contentPane.add (Box.createHorizontalGlue());
        contentPane.add (Box.createHorizontalGlue());
        contentPane.add (Box.createHorizontalGlue());
        contentPane.add (Box.createHorizontalGlue());
        contentPane.add (Box.createHorizontalGlue());

        contentPane. add (displayNumberLable);
        contentPane.add(displayNumberTextbox);
        contentPane.add(phoneNumberLable);
        contentPane.add(phoneNumberTextbox);
        contentPane.add (durationLable);
        contentPane.add (durationTextbox);

        contentPane.add(addMobileButton);
        contentPane.add(addMP3Button);
        contentPane.add (makeACall);
        contentPane.add (viewAll);
        contentPane.add (clear);
        

        frame .pack () ;
        frame.setVisible(true);
    }

    public void actionPerformed( ActionEvent event)
    {
        String command = event.getActionCommand();
        if (command.equals ("Add Mobile")) {
            addMobile();
        }

        if (command. equals( "Add MP3")) {
            addMP3 ();
        }

        if (command. equals ("Make a Call")) {
            makeACall();
        }
        
         if (command. equals ("View All")) {
            viewAll();
        }
        
          if (command. equals ("Clear")) {
            clear();
        }
        
       
    }

    public void addMobile()
    {
       
            Mobile newMobile= new Mobile (getCredit(), getaModel(),getPrice(), getWeight(), getSize());
            item.add(newMobile);
            JOptionPane.showMessageDialog(frame,"A new mobile is saved");

    }

    public void addMP3()
    {
        MP3 newMP3 = new MP3 (getMemory(), getaModel(),
                getPrice(), getWeight(), getSize());

        item.add(newMP3);
        JOptionPane.showMessageDialog(frame,"A new MP3 is added");
    }

    public void makeACall()
    {
    
        Gadget gadget = item.get(getDisplayNumber());
        if (getDisplayNumber() != -1 && gadget instanceof Mobile)
        {
            Mobile mobile= (Mobile) item.get(getDisplayNumber());
            mobile.makeCall(getPhoneNumber(), getDuration());
        }
        else
        {
            JOptionPane.showMessageDialog(frame,"This is not a mobile");

        }

    }
    
     public void viewAll()
    {     
        for(Gadget list :item){  
            
            System.out.print(item.indexOf(list)+1);
            
            list.display();
        
        }
    }
        
   
    public int getCredit()
    {
        int callCredit = Integer.parseInt(creditTextbox.getText());
        return callCredit;
    }

 
    private double getPrice()
    {
        double aPrice = Double.parseDouble(priceTextbox.getText());
        return aPrice;
    }

  
    private int getWeight()
    {
        int aWeight = Integer.parseInt(weightTextbox.getText());
        return aWeight;
    }

 
    private String getSize()
    {
        String aSize = sizeTextbox.getText();
        return sizeTextbox.getText();
     }
    

    public String getaModel()
    {
        String aModel = modelTextbox.getText();
        return aModel;
    }

    public double getMemory()
    { 
        double aMemory = Double.parseDouble(MemoryTextbox.getText());
        return aMemory;
    }

    public int getDisplayNumber()
    {
        int getDisplayNumber = -1;
        
          getDisplayNumber = Integer.parseInt(displayNumberTextbox.getText());
       
        
        return getDisplayNumber;
    }

    public int getDuration()
    {
        int Duration = Integer.parseInt(durationTextbox.getText());
        return 1;
    }

    public String getPhoneNumber()
    {
        String PhoneNumber = phoneNumberTextbox.getText(); 
        return PhoneNumber;
    }
    
    public void clear()
      {
    modelTextbox.setText(null);
    priceTextbox.setText(null);
    weightTextbox.setText(null);
    sizeTextbox.setText(null);
    displayNumberTextbox.setText(null);
    phoneNumberTextbox.setText(null);
    durationTextbox.setText(null);
    MemoryTextbox.setText(null);
    creditTextbox.setText(null);
    }
    
}