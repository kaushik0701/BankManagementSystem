package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField  panTextField, aadharTextField;
    JButton next;
    JRadioButton  syes, sno,eyes,eno;
    JComboBox religion, category, occupation, education,income;
    String formno;
  
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
        
        setTitle("NEW APPLICATION FORM - PAGE 2");
         
        
        JLabel additionDetails = new JLabel("Page 2: ADDICTIONAL Details");
        additionDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionDetails.setBounds(290,80,300,30);
        add(additionDetails);
        
        JLabel rel = new JLabel("Religion: ");
        rel.setFont(new Font("Raleway",Font.BOLD,20));
        rel.setBounds(100,140,100,30);
        add(rel);
        
        String valReligion[]={"Hindu","Muslim","Sikh","Christion","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        JLabel cat = new JLabel("Category: ");
        cat.setFont(new Font("Raleway",Font.BOLD,20));
        cat.setBounds(100,190,150,30);
        add(cat);
        
        String valCategory[]={"General","OBC","SC","ST","Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel inc = new JLabel("Income: ");
        inc.setFont(new Font("Raleway",Font.BOLD,20));
        inc.setBounds(100,240,150,30);
        add(inc);
        
        String incomeCategory[]={"Null","<1500000","<5000000","<upto 10000000","unlimited"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);        
        
        JLabel edu = new JLabel("Educational: ");
        edu.setFont(new Font("Raleway",Font.BOLD,20));
        edu.setBounds(100,290,150,30);
        add(edu);
       
        JLabel qua = new JLabel("qualification: ");
        qua.setFont(new Font("Raleway",Font.BOLD,20));
        qua.setBounds(100,315,150,30);
        add(qua);
        
        String eeducationValue[]={"Non-Graduation","Post-Graduation","Doctrate","other","nulla baithe ho"};
        education = new JComboBox(eeducationValue);
        education.setBounds(300,310,400,30);
        education.setBackground(Color.WHITE);
        add(education);   
        
        JLabel occ = new JLabel("Occupation: ");
        occ.setFont(new Font("Raleway",Font.BOLD,20));
        occ.setBounds(100,390,150,30);
        add(occ);
        
        String occupationvalue[]={"Salied Emp","Business-man","Student","Retired","Murkh ho "};
        occupation = new JComboBox(occupationvalue);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation); 
        
        JLabel pan = new JLabel("Pan Number: ");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,440,150,30);
        add(pan);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD,14));
        panTextField.setBounds(300,440,400,30);
        add(panTextField);
        
        JLabel aad = new JLabel("Aadhar Number: ");
        aad.setFont(new Font("Raleway",Font.BOLD,20));
        aad.setBounds(100,490,170,30);
        add(aad);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD,14));
        aadharTextField.setBounds(300,490,400,30);
        add(aadharTextField);
        
        JLabel sCiti = new JLabel("Senior citizon: ");
        sCiti.setFont(new Font("Raleway",Font.BOLD,20));
        sCiti.setBounds(100,540,150,30);
        add(sCiti);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450,540,120,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup citizengroup = new ButtonGroup();
        citizengroup.add(syes);
        citizengroup.add(sno);
        
        
        
        JLabel pincode = new JLabel("Existing Account: ");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450,590,120,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup exitGroup = new ButtonGroup();
        exitGroup.add(eno);
        exitGroup.add(eyes);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)category.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
       
        String seniorcitizon = null;
        if(syes.isSelected()){
            seniorcitizon = "Yes";
        }else if(sno.isSelected()){
            seniorcitizon = "No";
        }
        
        
        String existingAcc = null;
        if(eyes.isSelected()){
            existingAcc = "Yes";
        }else if(eyes.isSelected()){
            existingAcc = "No";
        }
        
        String span = panTextField.getText();
        String saadhar =aadharTextField.getText();
        
        
        try{
            
                Conn co = new Conn();
                String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"',"
                    + "'"+seducation+"','"+soccupation+"','"+span+"',"
                    + "'"+saadhar+"','"+seniorcitizon+"','"+existingAcc+"')";

                co.s.executeUpdate(query);
                
                
                //signup3 Object
                setVisible(false);
                new SignupThree(formno).setVisible(true);
           
        }catch(Exception e){
            System.out.println(e);
        } 
    }
    
    public static void main(String args[]) {
        
        new SignupTwo("");
    }
}
