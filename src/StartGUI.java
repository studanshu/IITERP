
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rajendra
 */
class elect implements Serializable {
    public int grade;
    public int credit;
    public String name;
    public String crd;
    public elect(String n,int g,int c)
    {
        name=n;
        grade=g;
        credit=c;
    }
    public String grades() {
        if(grade==10)
            crd="EX";
        else if(grade==9)
            crd="A";
        else if(grade==8)
            crd="B";
        else if(grade==7)
            crd="C";
        else if(grade==6)
            crd="D";
        else
            crd="F";
        return crd;
    }
}
class cores implements Serializable {
    public int grade;
    public int credit;
    public String name;
    public String crd;
    public cores(String n,int g,int c)
    {
        name=n;
        grade=g;
        credit=c;
    }
    public String grades() {
        if(grade==10)
            crd="EX";
        else if(grade==9)
            crd="A";
        else if(grade==8)
            crd="B";
        else if(grade==7)
            crd="C";
        else if(grade==6)
            crd="D";
        else
            crd="F";
        return crd;
    } 
}
class student implements Serializable{
    public ArrayList <elect> elect=new ArrayList();
    public ArrayList <cores> coresub=new ArrayList();
    public boolean registered;
    public String Name,Address,Regn,roll;
    public char passw[];
    public double gpa;
    public boolean signed;
    public boolean isGraded;
    public student(String nm,String add,String reg,String rollno,char pass[],double cg)
    {
        Name=nm;
        Address=add;
        Regn=reg;
        roll=rollno;
        passw=Arrays.copyOf(pass,pass.length);
        gpa=cg;
        registered=false;
        signed=false;
        isGraded=false;
    }
    public String name(){ return Name;}
    public String address(){ return Address;}
    public String RegNo(){ return Regn;}
    public String rollno(){return roll;}
    public double cgpa(){return gpa;}
    public char[] password(){ return passw;}
}
class teacher implements Serializable{
    public String Name,Address,Subject,Regn,roll;
    public char passw[];
    public boolean isFacad;
    public teacher(String nm,String add,String sub,String reg,String rollno,char pass[],String facad)
    {
        Name=nm;
        Address=add;
        Subject=sub;
        Regn=reg;
        roll=rollno;
        passw=Arrays.copyOf(pass,pass.length);
        if(facad.equalsIgnoreCase("Yes"))
            isFacad=true;
        else
            isFacad=false;
    }
    public String name(){ return Name;}
    public String address(){ return Address;}
    public String subject(){ return Subject;}
    public String RegNo(){ return Regn;}
    public String rollno(){return roll;}
    public char[] password(){ return passw;}
}
class core implements Serializable{
    public String NameC;
    public int credit;
    public core(String name, int crd)
    {
        NameC=name;
        credit=crd;
    }
    public String name(){ return NameC;}
    public int credit() { return credit;}
}
class electives implements Serializable{
    public String NameE;
    public int credit;
    public electives(String name, int crd)
    {
        NameE=name;
        credit=crd;
    }
    public String name(){ return NameE;}
    public int credit() { return credit;}
}
public class StartGUI extends javax.swing.JFrame {
    
    ArrayList<electives> el= new ArrayList();
    ArrayList<core> core=new ArrayList();
    ArrayList<teacher> teacher=new ArrayList();
    ArrayList<student> stud= new ArrayList();
    public StartGUI() throws IOException {
        
        initComponents();

        
        File file=null;
        file= new File("E:\\students.ser");
        ObjectInput ois=null;
        InputStream isr =null;
        InputStream buffer=null;
        try {
             if(!file.exists())
                 file.createNewFile();
             isr= new FileInputStream("E:\\students.ser");
             buffer = new BufferedInputStream(isr);
             ois = new ObjectInputStream(buffer);
             stud=(ArrayList)ois.readObject();
             ois.close();
             isr.close();
        } catch (Exception ex) {
            Logger.getLogger(StartGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        file= new File("E:\\teacher.ser");
        try {
             if(!file.exists())
                 file.createNewFile();   
             isr= new FileInputStream("E:\\teacher.ser");
             buffer = new BufferedInputStream(isr);
             ois = new ObjectInputStream(buffer);
             teacher=(ArrayList)ois.readObject();
             ois.close();
             isr.close();
        } catch (Exception ex) {
            Logger.getLogger(StartGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        file= new File("E:\\core.ser");
        try {
             if(!file.exists())
              file.createNewFile();
             isr= new FileInputStream("E:\\core.ser");
             buffer = new BufferedInputStream(isr);
             ois = new ObjectInputStream(buffer);
             core=(ArrayList)ois.readObject();
             ois.close();
             isr.close();
        } catch (Exception ex) {
            Logger.getLogger(StartGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        file= new File("E:\\elective.ser");
        try {
             if(!file.exists())
                 file.createNewFile();
             isr= new FileInputStream("E:\\elective.ser");
             buffer = new BufferedInputStream(isr);
             ois = new ObjectInputStream(buffer);
             el=(ArrayList)ois.readObject();
             ois.close();
             isr.close();
        } catch (Exception ex) {
            Logger.getLogger(StartGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        StartPanel.setVisible(true);
        StudentPanel.setVisible(false);
        TeacherPanel.setVisible(false);
        NomineePanel.setVisible(false);
        StudentAcadPanel.setVisible(false);
        StudentAcadActPanel.setVisible(false);
        TeacherAcadPanel.setVisible(false);
        TeacherfAcadPanel.setVisible(false);
        NomineeAcadPanel.setVisible(false);
        StudentSignupPanel.setVisible(false);
        TeacherSignupPanel.setVisible(false);
        SubjectSelectionPanel.setVisible(false);
        SubjectSelectionPanelE.setVisible(false);
        SignCardPanel.setVisible(false);
        StudentAcadInfoPanel.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        StartPanel = new javax.swing.JPanel();
        ExitLabel = new javax.swing.JLabel();
        StudentButton = new javax.swing.JButton();
        TeacherButton = new javax.swing.JButton();
        NomineeButton = new javax.swing.JButton();
        OptionLabel1 = new javax.swing.JLabel();
        StartLabel1 = new javax.swing.JLabel();
        StudentPanel = new javax.swing.JPanel();
        LogInButton = new javax.swing.JButton();
        SBackButton = new javax.swing.JButton();
        SignUpButton = new javax.swing.JButton();
        RegLabel = new javax.swing.JLabel();
        PassLabel = new javax.swing.JLabel();
        PassField = new javax.swing.JPasswordField();
        RegField = new javax.swing.JTextField();
        StudentLabel = new javax.swing.JLabel();
        StudentAcadInfoPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        GradeArea = new javax.swing.JTextArea();
        LogoutStudentButton1 = new javax.swing.JButton();
        CGPALabel = new javax.swing.JLabel();
        OptionLabel7 = new javax.swing.JLabel();
        StartLabel6 = new javax.swing.JLabel();
        StudentAcadPanel = new javax.swing.JPanel();
        StudentRegButton = new javax.swing.JButton();
        GradeStudentButton = new javax.swing.JButton();
        LogoutStudentButton = new javax.swing.JButton();
        OptionLabel = new javax.swing.JLabel();
        StartLabel = new javax.swing.JLabel();
        StudentAcadActPanel = new javax.swing.JPanel();
        CoreScrollPane = new javax.swing.JScrollPane();
        CoreArea = new javax.swing.JTextArea();
        ElectivePane = new javax.swing.JScrollPane();
        ElectiveList = new javax.swing.JList();
        ElectiveLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        AddElectiveButton = new javax.swing.JButton();
        SRegistrationButton = new javax.swing.JButton();
        SAABackButton = new javax.swing.JButton();
        OptionLabel4 = new javax.swing.JLabel();
        SAALabel = new javax.swing.JLabel();
        StudentSignupPanel = new javax.swing.JPanel();
        SNameField = new javax.swing.JTextField();
        RegLabel10 = new javax.swing.JLabel();
        RegLabel9 = new javax.swing.JLabel();
        SPassField = new javax.swing.JPasswordField();
        SRPassField = new javax.swing.JPasswordField();
        SRegNoField = new javax.swing.JTextField();
        AddressField = new javax.swing.JTextField();
        CreateAccountButton = new javax.swing.JButton();
        SBackButton1 = new javax.swing.JButton();
        RegLabel4 = new javax.swing.JLabel();
        RegLabel3 = new javax.swing.JLabel();
        PassLabel3 = new javax.swing.JLabel();
        StudentLabel3 = new javax.swing.JLabel();
        NomineePanel = new javax.swing.JPanel();
        LogInButton1 = new javax.swing.JButton();
        NBackButton = new javax.swing.JButton();
        RegLabel1 = new javax.swing.JLabel();
        PassLabel1 = new javax.swing.JLabel();
        PassField1 = new javax.swing.JPasswordField();
        RegField1 = new javax.swing.JTextField();
        StudentLabel1 = new javax.swing.JLabel();
        NomineeAcadPanel = new javax.swing.JPanel();
        CoreButton = new javax.swing.JButton();
        LogoutNomineeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        MaxElectiveField = new javax.swing.JTextField();
        ElectiveSignRegButton = new javax.swing.JButton();
        OptionLabel3 = new javax.swing.JLabel();
        StartLabel3 = new javax.swing.JLabel();
        SubjectSelectionPanel = new javax.swing.JPanel();
        LogInButton3 = new javax.swing.JButton();
        NBackButton1 = new javax.swing.JButton();
        RegLabel7 = new javax.swing.JLabel();
        PassLabel5 = new javax.swing.JLabel();
        CreditField = new javax.swing.JTextField();
        SubjectField = new javax.swing.JTextField();
        StudentLabel5 = new javax.swing.JLabel();
        SubjectSelectionPanelE = new javax.swing.JPanel();
        LogInButton4 = new javax.swing.JButton();
        NBackButton2 = new javax.swing.JButton();
        RegLabel8 = new javax.swing.JLabel();
        PassLabel6 = new javax.swing.JLabel();
        CreditField1 = new javax.swing.JTextField();
        SubjectField1 = new javax.swing.JTextField();
        StudentLabel6 = new javax.swing.JLabel();
        TeacherPanel = new javax.swing.JPanel();
        LogInButton2 = new javax.swing.JButton();
        SignUpButton2 = new javax.swing.JButton();
        TBackButton = new javax.swing.JButton();
        RegLabel2 = new javax.swing.JLabel();
        PassLabel2 = new javax.swing.JLabel();
        PassField2 = new javax.swing.JPasswordField();
        RegField2 = new javax.swing.JTextField();
        StudentLabel2 = new javax.swing.JLabel();
        TeacherAcadPanel = new javax.swing.JPanel();
        GradeTeacherButton = new javax.swing.JButton();
        LogoutTeacherButton = new javax.swing.JButton();
        OptionLabel2 = new javax.swing.JLabel();
        StartLabel2 = new javax.swing.JLabel();
        TeacherfAcadPanel = new javax.swing.JPanel();
        GradeTeacherButton1 = new javax.swing.JButton();
        LogoutTeacherButton1 = new javax.swing.JButton();
        SignRegButton1 = new javax.swing.JButton();
        OptionLabel5 = new javax.swing.JLabel();
        StartLabel4 = new javax.swing.JLabel();
        TeacherSignupPanel = new javax.swing.JPanel();
        TNameField = new javax.swing.JTextField();
        TRegNoField = new javax.swing.JTextField();
        TRPassField = new javax.swing.JPasswordField();
        TPassField = new javax.swing.JPasswordField();
        AddressField1 = new javax.swing.JTextField();
        CreateAccountButton1 = new javax.swing.JButton();
        FacultyAdvisor = new javax.swing.JComboBox();
        TSubjectSelection = new javax.swing.JComboBox();
        RegLabel11 = new javax.swing.JLabel();
        RegLabel12 = new javax.swing.JLabel();
        TBackButton1 = new javax.swing.JButton();
        RegLabel5 = new javax.swing.JLabel();
        RegLabel6 = new javax.swing.JLabel();
        PassLabel4 = new javax.swing.JLabel();
        StudentLabel4 = new javax.swing.JLabel();
        SignCardPanel = new javax.swing.JPanel();
        SignCardPane = new javax.swing.JScrollPane();
        SignCardArea = new javax.swing.JTextArea();
        SignRegButton2 = new javax.swing.JButton();
        OptionLabel6 = new javax.swing.JLabel();
        StartLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        StartPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ExitLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ExitLabel.setText("X");
        ExitLabel.setBorder(new javax.swing.border.MatteBorder(null));
        ExitLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ExitLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitLabelMouseClicked(evt);
            }
        });
        StartPanel.add(ExitLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 30, -1));

        StudentButton.setBackground(new java.awt.Color(255, 255, 255));
        StudentButton.setForeground(new java.awt.Color(153, 0, 0));
        StudentButton.setText("Student");
        StudentButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        StudentButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        StudentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StudentButtonMouseClicked(evt);
            }
        });
        StartPanel.add(StudentButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 240, 70, -1));

        TeacherButton.setBackground(new java.awt.Color(255, 255, 255));
        TeacherButton.setForeground(new java.awt.Color(153, 0, 0));
        TeacherButton.setText("Teacher");
        TeacherButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        TeacherButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TeacherButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TeacherButtonMouseClicked(evt);
            }
        });
        TeacherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TeacherButtonActionPerformed(evt);
            }
        });
        StartPanel.add(TeacherButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 70, -1));

        NomineeButton.setBackground(new java.awt.Color(255, 255, 255));
        NomineeButton.setForeground(new java.awt.Color(153, 0, 0));
        NomineeButton.setText("Nominee");
        NomineeButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        NomineeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NomineeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NomineeButtonMouseClicked(evt);
            }
        });
        StartPanel.add(NomineeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 70, -1));

        OptionLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        OptionLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OptionLabel1.setText("Select Appropiate Option");
        StartPanel.add(OptionLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, -1));

        StartLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erpPackage/Image/ERP.jpg"))); // NOI18N
        StartPanel.add(StartLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        getContentPane().add(StartPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        StudentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LogInButton.setBackground(new java.awt.Color(255, 255, 255));
        LogInButton.setForeground(new java.awt.Color(153, 0, 0));
        LogInButton.setText("Login");
        LogInButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        LogInButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogInButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogInButtonMouseClicked(evt);
            }
        });
        LogInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInButtonActionPerformed(evt);
            }
        });
        StudentPanel.add(LogInButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 70, -1));

        SBackButton.setBackground(new java.awt.Color(255, 255, 255));
        SBackButton.setForeground(new java.awt.Color(153, 0, 0));
        SBackButton.setText("Back");
        SBackButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        SBackButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SBackButtonMouseClicked(evt);
            }
        });
        StudentPanel.add(SBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, -1));

        SignUpButton.setBackground(new java.awt.Color(255, 255, 255));
        SignUpButton.setForeground(new java.awt.Color(153, 0, 0));
        SignUpButton.setText("SignUp");
        SignUpButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        SignUpButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SignUpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SignUpButtonMouseClicked(evt);
            }
        });
        StudentPanel.add(SignUpButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 70, -1));

        RegLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        RegLabel.setText("Registration Number");
        StudentPanel.add(RegLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        PassLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        PassLabel.setText("Password");
        StudentPanel.add(PassLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 50, -1));

        PassField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        StudentPanel.add(PassField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 110, 20));

        RegField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        StudentPanel.add(RegField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 110, 20));

        StudentLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erpPackage/Image/ERP.jpg"))); // NOI18N
        StudentPanel.add(StudentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        getContentPane().add(StudentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        StudentAcadInfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GradeArea.setEditable(false);
        GradeArea.setBackground(new java.awt.Color(204, 204, 204));
        GradeArea.setColumns(20);
        GradeArea.setRows(5);
        GradeArea.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jScrollPane1.setViewportView(GradeArea);

        StudentAcadInfoPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 320, 190));

        LogoutStudentButton1.setBackground(new java.awt.Color(255, 255, 255));
        LogoutStudentButton1.setForeground(new java.awt.Color(153, 0, 0));
        LogoutStudentButton1.setText("Back");
        LogoutStudentButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        LogoutStudentButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogoutStudentButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutStudentButton1MouseClicked(evt);
            }
        });
        LogoutStudentButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutStudentButton1ActionPerformed(evt);
            }
        });
        StudentAcadInfoPanel.add(LogoutStudentButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, -1));

        CGPALabel.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        CGPALabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StudentAcadInfoPanel.add(CGPALabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 400, 30));

        OptionLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        OptionLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OptionLabel7.setText("Grade Sheet");
        StudentAcadInfoPanel.add(OptionLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, -1));

        StartLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erpPackage/Image/ERP.jpg"))); // NOI18N
        StudentAcadInfoPanel.add(StartLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        getContentPane().add(StudentAcadInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        StudentAcadPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        StudentRegButton.setBackground(new java.awt.Color(255, 255, 255));
        StudentRegButton.setForeground(new java.awt.Color(153, 0, 0));
        StudentRegButton.setText("Student Academic Activites");
        StudentRegButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        StudentRegButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        StudentRegButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StudentRegButtonMouseClicked(evt);
            }
        });
        StudentRegButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentRegButtonActionPerformed(evt);
            }
        });
        StudentAcadPanel.add(StudentRegButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 150, -1));

        GradeStudentButton.setBackground(new java.awt.Color(255, 255, 255));
        GradeStudentButton.setForeground(new java.awt.Color(153, 0, 0));
        GradeStudentButton.setText("Your Academic Information");
        GradeStudentButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        GradeStudentButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GradeStudentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GradeStudentButtonMouseClicked(evt);
            }
        });
        GradeStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GradeStudentButtonActionPerformed(evt);
            }
        });
        StudentAcadPanel.add(GradeStudentButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 160, -1));

        LogoutStudentButton.setBackground(new java.awt.Color(255, 255, 255));
        LogoutStudentButton.setForeground(new java.awt.Color(153, 0, 0));
        LogoutStudentButton.setText("LogOut");
        LogoutStudentButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        LogoutStudentButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogoutStudentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutStudentButtonMouseClicked(evt);
            }
        });
        LogoutStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutStudentButtonActionPerformed(evt);
            }
        });
        StudentAcadPanel.add(LogoutStudentButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 150, -1));

        OptionLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        OptionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OptionLabel.setText("WELCOME");
        StudentAcadPanel.add(OptionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, -1));

        StartLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erpPackage/Image/ERP.jpg"))); // NOI18N
        StudentAcadPanel.add(StartLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        getContentPane().add(StudentAcadPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        StudentAcadActPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CoreArea.setEditable(false);
        CoreArea.setColumns(20);
        CoreArea.setRows(5);
        CoreScrollPane.setViewportView(CoreArea);

        StudentAcadActPanel.add(CoreScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 160, -1));

        ElectiveList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ElectiveList.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        ElectiveList.setOpaque(false);
        ElectivePane.setViewportView(ElectiveList);

        StudentAcadActPanel.add(ElectivePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 150, 90));

        ElectiveLabel.setBackground(new java.awt.Color(255, 255, 255));
        ElectiveLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        StudentAcadActPanel.add(ElectiveLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 60, 20));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel5.setText("Electives");
        StudentAcadActPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setText("Core Subjects");
        StudentAcadActPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, -1, -1));

        AddElectiveButton.setBackground(new java.awt.Color(255, 255, 255));
        AddElectiveButton.setForeground(new java.awt.Color(153, 0, 0));
        AddElectiveButton.setText("Add");
        AddElectiveButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        AddElectiveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddElectiveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddElectiveButtonMouseClicked(evt);
            }
        });
        AddElectiveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddElectiveButtonActionPerformed(evt);
            }
        });
        StudentAcadActPanel.add(AddElectiveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 60, 20));

        SRegistrationButton.setBackground(new java.awt.Color(255, 255, 255));
        SRegistrationButton.setForeground(new java.awt.Color(153, 0, 0));
        SRegistrationButton.setText("Register");
        SRegistrationButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        SRegistrationButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SRegistrationButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SRegistrationButtonMouseClicked(evt);
            }
        });
        SRegistrationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SRegistrationButtonActionPerformed(evt);
            }
        });
        StudentAcadActPanel.add(SRegistrationButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 120, -1));

        SAABackButton.setBackground(new java.awt.Color(255, 255, 255));
        SAABackButton.setForeground(new java.awt.Color(153, 0, 0));
        SAABackButton.setText("Back");
        SAABackButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        SAABackButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SAABackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SAABackButtonMouseClicked(evt);
            }
        });
        SAABackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SAABackButtonActionPerformed(evt);
            }
        });
        StudentAcadActPanel.add(SAABackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 70, -1));

        OptionLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        OptionLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OptionLabel4.setText("Final Registration");
        StudentAcadActPanel.add(OptionLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, -1));

        SAALabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erpPackage/Image/ERP.jpg"))); // NOI18N
        StudentAcadActPanel.add(SAALabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        getContentPane().add(StudentAcadActPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        StudentSignupPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SNameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        StudentSignupPanel.add(SNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 110, 20));

        RegLabel10.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        RegLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        RegLabel10.setText("Re-enter Password");
        StudentSignupPanel.add(RegLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 110, -1));

        RegLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        RegLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        RegLabel9.setText("Enter Password");
        StudentSignupPanel.add(RegLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 110, -1));

        SPassField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPassFieldActionPerformed(evt);
            }
        });
        StudentSignupPanel.add(SPassField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 110, -1));
        StudentSignupPanel.add(SRPassField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 110, -1));

        SRegNoField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        StudentSignupPanel.add(SRegNoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 110, 20));

        AddressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddressFieldActionPerformed(evt);
            }
        });
        StudentSignupPanel.add(AddressField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 160, 40));

        CreateAccountButton.setBackground(new java.awt.Color(255, 255, 255));
        CreateAccountButton.setForeground(new java.awt.Color(153, 0, 0));
        CreateAccountButton.setText("Create Account");
        CreateAccountButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        CreateAccountButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CreateAccountButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreateAccountButtonMouseClicked(evt);
            }
        });
        CreateAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateAccountButtonActionPerformed(evt);
            }
        });
        StudentSignupPanel.add(CreateAccountButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 100, -1));

        SBackButton1.setBackground(new java.awt.Color(255, 255, 255));
        SBackButton1.setForeground(new java.awt.Color(153, 0, 0));
        SBackButton1.setText("Back");
        SBackButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        SBackButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SBackButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SBackButton1MouseClicked(evt);
            }
        });
        StudentSignupPanel.add(SBackButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, -1));

        RegLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        RegLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        RegLabel4.setText("Address");
        StudentSignupPanel.add(RegLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 110, -1));

        RegLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        RegLabel3.setText("Registration Number");
        StudentSignupPanel.add(RegLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        PassLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        PassLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        PassLabel3.setText("Name");
        StudentSignupPanel.add(PassLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 100, 20));

        StudentLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erpPackage/Image/ERP.jpg"))); // NOI18N
        StudentSignupPanel.add(StudentLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        getContentPane().add(StudentSignupPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        NomineePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LogInButton1.setBackground(new java.awt.Color(255, 255, 255));
        LogInButton1.setForeground(new java.awt.Color(153, 0, 0));
        LogInButton1.setText("Login");
        LogInButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        LogInButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogInButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogInButton1MouseClicked(evt);
            }
        });
        LogInButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInButton1ActionPerformed(evt);
            }
        });
        NomineePanel.add(LogInButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 70, -1));

        NBackButton.setBackground(new java.awt.Color(255, 255, 255));
        NBackButton.setForeground(new java.awt.Color(153, 0, 0));
        NBackButton.setText("Back");
        NBackButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        NBackButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NBackButtonMouseClicked(evt);
            }
        });
        NomineePanel.add(NBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, -1));

        RegLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        RegLabel1.setText("Registration Number");
        NomineePanel.add(RegLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        PassLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        PassLabel1.setText("Password");
        NomineePanel.add(PassLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 50, -1));

        PassField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NomineePanel.add(PassField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 110, 20));

        RegField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NomineePanel.add(RegField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 110, 20));

        StudentLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erpPackage/Image/ERP.jpg"))); // NOI18N
        NomineePanel.add(StudentLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        getContentPane().add(NomineePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        NomineeAcadPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CoreButton.setBackground(new java.awt.Color(255, 255, 255));
        CoreButton.setForeground(new java.awt.Color(153, 0, 0));
        CoreButton.setText("Core Subjects");
        CoreButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        CoreButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CoreButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CoreButtonMouseClicked(evt);
            }
        });
        NomineeAcadPanel.add(CoreButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 150, -1));

        LogoutNomineeButton.setBackground(new java.awt.Color(255, 255, 255));
        LogoutNomineeButton.setForeground(new java.awt.Color(153, 0, 0));
        LogoutNomineeButton.setText("LogOut");
        LogoutNomineeButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        LogoutNomineeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogoutNomineeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutNomineeButtonMouseClicked(evt);
            }
        });
        LogoutNomineeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutNomineeButtonActionPerformed(evt);
            }
        });
        NomineeAcadPanel.add(LogoutNomineeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 150, -1));

        jLabel1.setText("Maximum Number of Electives");
        NomineeAcadPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 170, -1));

        MaxElectiveField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaxElectiveFieldActionPerformed(evt);
            }
        });
        NomineeAcadPanel.add(MaxElectiveField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 60, 20));

        ElectiveSignRegButton.setBackground(new java.awt.Color(255, 255, 255));
        ElectiveSignRegButton.setForeground(new java.awt.Color(153, 0, 0));
        ElectiveSignRegButton.setText("Elective Subjects");
        ElectiveSignRegButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        ElectiveSignRegButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ElectiveSignRegButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ElectiveSignRegButtonMouseClicked(evt);
            }
        });
        ElectiveSignRegButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ElectiveSignRegButtonActionPerformed(evt);
            }
        });
        NomineeAcadPanel.add(ElectiveSignRegButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 160, 20));

        OptionLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        OptionLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OptionLabel3.setText("WELCOME");
        NomineeAcadPanel.add(OptionLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, -1));

        StartLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erpPackage/Image/ERP.jpg"))); // NOI18N
        NomineeAcadPanel.add(StartLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        getContentPane().add(NomineeAcadPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        SubjectSelectionPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LogInButton3.setBackground(new java.awt.Color(255, 255, 255));
        LogInButton3.setForeground(new java.awt.Color(153, 0, 0));
        LogInButton3.setText("Enter");
        LogInButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        LogInButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogInButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogInButton3MouseClicked(evt);
            }
        });
        LogInButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInButton3ActionPerformed(evt);
            }
        });
        SubjectSelectionPanel.add(LogInButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 70, -1));

        NBackButton1.setBackground(new java.awt.Color(255, 255, 255));
        NBackButton1.setForeground(new java.awt.Color(153, 0, 0));
        NBackButton1.setText("Back");
        NBackButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        NBackButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NBackButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NBackButton1MouseClicked(evt);
            }
        });
        SubjectSelectionPanel.add(NBackButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, -1));

        RegLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        RegLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        RegLabel7.setText("Subject Name");
        SubjectSelectionPanel.add(RegLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 110, -1));

        PassLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        PassLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        PassLabel5.setText("Credits");
        SubjectSelectionPanel.add(PassLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 50, -1));

        CreditField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CreditField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreditFieldActionPerformed(evt);
            }
        });
        SubjectSelectionPanel.add(CreditField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 110, 20));

        SubjectField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SubjectField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubjectFieldActionPerformed(evt);
            }
        });
        SubjectSelectionPanel.add(SubjectField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 110, 20));

        StudentLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erpPackage/Image/ERP.jpg"))); // NOI18N
        SubjectSelectionPanel.add(StudentLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        getContentPane().add(SubjectSelectionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        SubjectSelectionPanelE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LogInButton4.setBackground(new java.awt.Color(255, 255, 255));
        LogInButton4.setForeground(new java.awt.Color(153, 0, 0));
        LogInButton4.setText("Enter");
        LogInButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        LogInButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogInButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogInButton4MouseClicked(evt);
            }
        });
        LogInButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInButton4ActionPerformed(evt);
            }
        });
        SubjectSelectionPanelE.add(LogInButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 70, -1));

        NBackButton2.setBackground(new java.awt.Color(255, 255, 255));
        NBackButton2.setForeground(new java.awt.Color(153, 0, 0));
        NBackButton2.setText("Back");
        NBackButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        NBackButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NBackButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NBackButton2MouseClicked(evt);
            }
        });
        SubjectSelectionPanelE.add(NBackButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, -1));

        RegLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        RegLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        RegLabel8.setText("Subject Name");
        SubjectSelectionPanelE.add(RegLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 110, -1));

        PassLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        PassLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        PassLabel6.setText("Credits");
        SubjectSelectionPanelE.add(PassLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 50, -1));

        CreditField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CreditField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreditField1ActionPerformed(evt);
            }
        });
        SubjectSelectionPanelE.add(CreditField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 110, 20));

        SubjectField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SubjectField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubjectField1ActionPerformed(evt);
            }
        });
        SubjectSelectionPanelE.add(SubjectField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 110, 20));

        StudentLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erpPackage/Image/ERP.jpg"))); // NOI18N
        SubjectSelectionPanelE.add(StudentLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        getContentPane().add(SubjectSelectionPanelE, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        TeacherPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LogInButton2.setBackground(new java.awt.Color(255, 255, 255));
        LogInButton2.setForeground(new java.awt.Color(153, 0, 0));
        LogInButton2.setText("Login");
        LogInButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        LogInButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogInButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogInButton2MouseClicked(evt);
            }
        });
        LogInButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInButton2ActionPerformed(evt);
            }
        });
        TeacherPanel.add(LogInButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 70, -1));

        SignUpButton2.setBackground(new java.awt.Color(255, 255, 255));
        SignUpButton2.setForeground(new java.awt.Color(153, 0, 0));
        SignUpButton2.setText("SignUp");
        SignUpButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        SignUpButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SignUpButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SignUpButton2MouseClicked(evt);
            }
        });
        TeacherPanel.add(SignUpButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 70, -1));

        TBackButton.setBackground(new java.awt.Color(255, 255, 255));
        TBackButton.setForeground(new java.awt.Color(153, 0, 0));
        TBackButton.setText("Back");
        TBackButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        TBackButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBackButtonMouseClicked(evt);
            }
        });
        TeacherPanel.add(TBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, -1));

        RegLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        RegLabel2.setText("Registration Number");
        TeacherPanel.add(RegLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        PassLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        PassLabel2.setText("Password");
        TeacherPanel.add(PassLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 50, -1));

        PassField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TeacherPanel.add(PassField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 110, 20));

        RegField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TeacherPanel.add(RegField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 110, 20));

        StudentLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erpPackage/Image/ERP.jpg"))); // NOI18N
        TeacherPanel.add(StudentLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        getContentPane().add(TeacherPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        TeacherAcadPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GradeTeacherButton.setBackground(new java.awt.Color(255, 255, 255));
        GradeTeacherButton.setForeground(new java.awt.Color(153, 0, 0));
        GradeTeacherButton.setText("Enter Grades");
        GradeTeacherButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        GradeTeacherButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GradeTeacherButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GradeTeacherButtonMouseClicked(evt);
            }
        });
        TeacherAcadPanel.add(GradeTeacherButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 160, -1));

        LogoutTeacherButton.setBackground(new java.awt.Color(255, 255, 255));
        LogoutTeacherButton.setForeground(new java.awt.Color(153, 0, 0));
        LogoutTeacherButton.setText("LogOut");
        LogoutTeacherButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        LogoutTeacherButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogoutTeacherButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutTeacherButtonMouseClicked(evt);
            }
        });
        LogoutTeacherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutTeacherButtonActionPerformed(evt);
            }
        });
        TeacherAcadPanel.add(LogoutTeacherButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 150, -1));

        OptionLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        OptionLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OptionLabel2.setText("WELCOME");
        TeacherAcadPanel.add(OptionLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, -1));

        StartLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erpPackage/Image/ERP.jpg"))); // NOI18N
        TeacherAcadPanel.add(StartLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        getContentPane().add(TeacherAcadPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        TeacherfAcadPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TeacherfAcadPanelMouseClicked(evt);
            }
        });
        TeacherfAcadPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GradeTeacherButton1.setBackground(new java.awt.Color(255, 255, 255));
        GradeTeacherButton1.setForeground(new java.awt.Color(153, 0, 0));
        GradeTeacherButton1.setText("Enter Grades");
        GradeTeacherButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        GradeTeacherButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GradeTeacherButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GradeTeacherButton1MouseClicked(evt);
            }
        });
        TeacherfAcadPanel.add(GradeTeacherButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 160, -1));

        LogoutTeacherButton1.setBackground(new java.awt.Color(255, 255, 255));
        LogoutTeacherButton1.setForeground(new java.awt.Color(153, 0, 0));
        LogoutTeacherButton1.setText("LogOut");
        LogoutTeacherButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        LogoutTeacherButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogoutTeacherButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutTeacherButton1MouseClicked(evt);
            }
        });
        LogoutTeacherButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutTeacherButton1ActionPerformed(evt);
            }
        });
        TeacherfAcadPanel.add(LogoutTeacherButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 150, -1));

        SignRegButton1.setBackground(new java.awt.Color(255, 255, 255));
        SignRegButton1.setForeground(new java.awt.Color(153, 0, 0));
        SignRegButton1.setText("Sign Registration Card");
        SignRegButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        SignRegButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SignRegButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SignRegButton1MouseClicked(evt);
            }
        });
        SignRegButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignRegButton1ActionPerformed(evt);
            }
        });
        TeacherfAcadPanel.add(SignRegButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 160, 20));

        OptionLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        OptionLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OptionLabel5.setText("WELCOME");
        TeacherfAcadPanel.add(OptionLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, -1));

        StartLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erpPackage/Image/ERP.jpg"))); // NOI18N
        TeacherfAcadPanel.add(StartLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        getContentPane().add(TeacherfAcadPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        TeacherSignupPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TNameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TeacherSignupPanel.add(TNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 110, 20));

        TRegNoField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TeacherSignupPanel.add(TRegNoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 110, 20));
        TeacherSignupPanel.add(TRPassField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 110, -1));
        TeacherSignupPanel.add(TPassField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 110, -1));

        AddressField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddressField1ActionPerformed(evt);
            }
        });
        TeacherSignupPanel.add(AddressField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 160, 40));

        CreateAccountButton1.setBackground(new java.awt.Color(255, 255, 255));
        CreateAccountButton1.setForeground(new java.awt.Color(153, 0, 0));
        CreateAccountButton1.setText("Create Account");
        CreateAccountButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        CreateAccountButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CreateAccountButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreateAccountButton1MouseClicked(evt);
            }
        });
        CreateAccountButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateAccountButton1ActionPerformed(evt);
            }
        });
        TeacherSignupPanel.add(CreateAccountButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 100, -1));

        FacultyAdvisor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Are you a Faculty Advisor?>" }));
        FacultyAdvisor.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        TeacherSignupPanel.add(FacultyAdvisor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 180, -1));

        TSubjectSelection.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Select Your Subject>" }));
        TSubjectSelection.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        TeacherSignupPanel.add(TSubjectSelection, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 180, -1));

        RegLabel11.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        RegLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        RegLabel11.setText("Re-enter Password");
        TeacherSignupPanel.add(RegLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 110, -1));

        RegLabel12.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        RegLabel12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        RegLabel12.setText("Enter Password");
        TeacherSignupPanel.add(RegLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 110, -1));

        TBackButton1.setBackground(new java.awt.Color(255, 255, 255));
        TBackButton1.setForeground(new java.awt.Color(153, 0, 0));
        TBackButton1.setText("Back");
        TBackButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        TBackButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TBackButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBackButton1MouseClicked(evt);
            }
        });
        TeacherSignupPanel.add(TBackButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, -1));

        RegLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        RegLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        RegLabel5.setText("Address");
        TeacherSignupPanel.add(RegLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 110, -1));

        RegLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        RegLabel6.setText("Registration Number");
        TeacherSignupPanel.add(RegLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        PassLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        PassLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        PassLabel4.setText("Name");
        TeacherSignupPanel.add(PassLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 100, 20));

        StudentLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erpPackage/Image/ERP.jpg"))); // NOI18N
        TeacherSignupPanel.add(StudentLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        getContentPane().add(TeacherSignupPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        SignCardPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SignCardArea.setEditable(false);
        SignCardArea.setColumns(20);
        SignCardArea.setRows(5);
        SignCardArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SignCardPane.setViewportView(SignCardArea);

        SignCardPanel.add(SignCardPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, 250));

        SignRegButton2.setBackground(new java.awt.Color(255, 255, 255));
        SignRegButton2.setForeground(new java.awt.Color(153, 0, 0));
        SignRegButton2.setText("Sign Registration Card");
        SignRegButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 0), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        SignRegButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SignRegButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SignRegButton2MouseClicked(evt);
            }
        });
        SignRegButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignRegButton2ActionPerformed(evt);
            }
        });
        SignCardPanel.add(SignRegButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 160, 20));

        OptionLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        OptionLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OptionLabel6.setText("Student Registered");
        SignCardPanel.add(OptionLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, -1));

        StartLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erpPackage/Image/ERP.jpg"))); // NOI18N
        SignCardPanel.add(StartLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        getContentPane().add(SignCardPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LogInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogInButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LogInButtonActionPerformed

    private void LogInButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogInButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LogInButton1ActionPerformed

    private void LogInButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogInButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LogInButton2ActionPerformed

    private void GradeStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GradeStudentButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GradeStudentButtonActionPerformed

    private void LogoutStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutStudentButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutStudentButtonActionPerformed

    private void LogoutTeacherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutTeacherButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutTeacherButtonActionPerformed

    private void StudentRegButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentRegButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StudentRegButtonActionPerformed

    private void LogoutNomineeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutNomineeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutNomineeButtonActionPerformed

    private void ElectiveSignRegButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ElectiveSignRegButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ElectiveSignRegButtonActionPerformed

    private void StudentButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentButtonMouseClicked
        StartPanel.setVisible(false);
        StudentPanel.setVisible(true);
        PassField.setText("");
        RegField.setText("");
    }//GEN-LAST:event_StudentButtonMouseClicked

    private void SBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SBackButtonMouseClicked
        StartPanel.setVisible(true);
        StudentPanel.setVisible(false);
    }//GEN-LAST:event_SBackButtonMouseClicked

    private void NomineeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NomineeButtonMouseClicked
        StartPanel.setVisible(false);
        NomineePanel.setVisible(true);
    }//GEN-LAST:event_NomineeButtonMouseClicked

    private void NBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NBackButtonMouseClicked
        StartPanel.setVisible(true);
        NomineePanel.setVisible(false);
    }//GEN-LAST:event_NBackButtonMouseClicked

    private void TeacherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TeacherButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TeacherButtonActionPerformed

    private void TeacherButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TeacherButtonMouseClicked
        StartPanel.setVisible(false);
        TeacherPanel.setVisible(true);
        PassField2.setText("");
        RegField2.setText("");
    }//GEN-LAST:event_TeacherButtonMouseClicked

    private void TBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBackButtonMouseClicked
        StartPanel.setVisible(true);
        TeacherPanel.setVisible(false);
    }//GEN-LAST:event_TBackButtonMouseClicked

    private void CreateAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateAccountButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateAccountButtonActionPerformed

    private void SBackButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SBackButton1MouseClicked
        StudentPanel.setVisible(true);
        StudentSignupPanel.setVisible(false);
    }//GEN-LAST:event_SBackButton1MouseClicked

    private void AddressFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddressFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddressFieldActionPerformed

    private void AddressField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddressField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddressField1ActionPerformed

    private void CreateAccountButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateAccountButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateAccountButton1ActionPerformed

    private void TBackButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBackButton1MouseClicked
        TeacherPanel.setVisible(true);
        TeacherSignupPanel.setVisible(false);
    }//GEN-LAST:event_TBackButton1MouseClicked

    private void SignUpButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignUpButton2MouseClicked
        TeacherPanel.setVisible(false);
        TeacherSignupPanel.setVisible(true);
        TSubjectSelection.removeAllItems();
        FacultyAdvisor.removeAllItems();
        FacultyAdvisor.addItem("<Are you a Faculty Advisor?>");
        FacultyAdvisor.addItem("Yes");
        FacultyAdvisor.addItem("No");
        TSubjectSelection.addItem("<Select your Subject>");
        int i;
        for(i=0;i<core.size();i++)
            TSubjectSelection.addItem(core.get(i).name());
        for(i=0;i<el.size();i++)
            TSubjectSelection.addItem(el.get(i).name());
    }//GEN-LAST:event_SignUpButton2MouseClicked

    private void SignUpButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignUpButtonMouseClicked
        StudentPanel.setVisible(false);
        StudentSignupPanel.setVisible(true);
    }//GEN-LAST:event_SignUpButtonMouseClicked

    private void LogInButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogInButtonMouseClicked
        
        try {
        if(Integer.parseInt(RegField.getText().substring(1,RegField.getText().length()))>stud.size() || RegField.getText().charAt(0)!='S')
        {
            
            JOptionPane.showMessageDialog(null, "Invalid Registration Number.Please re-enter.");
        }
        else
        {
            
            if(Arrays.equals(stud.get(Integer.parseInt(RegField.getText().substring(1,RegField.getText().length()))-1).password(),PassField.getPassword()))
            { 
                StudentAcadPanel.setVisible(true);
                StudentPanel.setVisible(false);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Wrong Password.Please re-enter.");
            }
        }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please fill the form properly.");
        }
    }//GEN-LAST:event_LogInButtonMouseClicked

    private void LogInButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogInButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LogInButton3ActionPerformed

    private void NBackButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NBackButton1MouseClicked
        NomineeAcadPanel.setVisible(true);
        SubjectSelectionPanel.setVisible(false);
    }//GEN-LAST:event_NBackButton1MouseClicked

    private void SubjectFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubjectFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SubjectFieldActionPerformed

    private void CreditFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreditFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreditFieldActionPerformed

    private void CoreButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CoreButtonMouseClicked
        NomineeAcadPanel.setVisible(false);
        SubjectSelectionPanel.setVisible(true);
    }//GEN-LAST:event_CoreButtonMouseClicked

    private void ElectiveSignRegButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ElectiveSignRegButtonMouseClicked
        NomineeAcadPanel.setVisible(false);
        SubjectSelectionPanelE.setVisible(true);
    }//GEN-LAST:event_ElectiveSignRegButtonMouseClicked

    private void MaxElectiveFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaxElectiveFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaxElectiveFieldActionPerformed

    private void LogInButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogInButton1MouseClicked
        char[] correctPassword = { 'b', 'u', 'g', 'a', 'b', 'o', 'o' };
        if(RegField1.getText().equals("N001") && Arrays.equals(PassField1.getPassword(),correctPassword))
        {
            NomineeAcadPanel.setVisible(true);
            NomineePanel.setVisible(false);
        }
        else
            JOptionPane.showMessageDialog(null,"Incorrect Password or Registration Number.");
        RegField1.setText("");
        PassField1.setText("");
        while(core.isEmpty()==false)
            core.remove(0);
        while(el.isEmpty()==false)
            el.remove(0);
        while(stud.isEmpty()==false)
            stud.remove(0);
        while(teacher.isEmpty()==false)
            teacher.remove(0);
    }//GEN-LAST:event_LogInButton1MouseClicked

    private void LogoutNomineeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutNomineeButtonMouseClicked
            try {
            if(MaxElectiveField.getText().equals("") || el.size()==0 || core.size()==0 || Integer.parseInt(MaxElectiveField.getText())>el.size())
            {
                JOptionPane.showMessageDialog(null, "Please fill up the form properly.");
            }
            else
            {
                ElectiveLabel.setText("Select "+MaxElectiveField.getText());
                NomineeAcadPanel.setVisible(false);
                NomineePanel.setVisible(true);
            }
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Please fill the form properly.");
            }
            MaxElectiveField.setText("");
    }//GEN-LAST:event_LogoutNomineeButtonMouseClicked

    private void LogInButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogInButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LogInButton4ActionPerformed

    private void NBackButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NBackButton2MouseClicked
        NomineeAcadPanel.setVisible(true);
        SubjectSelectionPanelE.setVisible(false);
    }//GEN-LAST:event_NBackButton2MouseClicked

    private void CreditField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreditField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreditField1ActionPerformed

    private void SubjectField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubjectField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SubjectField1ActionPerformed

    private void LogInButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogInButton4MouseClicked
        if(SubjectField1.getText().equals("") || CreditField1.getText().equals(""))
           JOptionPane.showMessageDialog(null, "Please complete the form.");
       else
        {
           try { 
           el.add(new electives(SubjectField1.getText(),Integer.parseInt(CreditField1.getText())));
           SubjectField1.setText("");
           CreditField1.setText("");
           } catch(Exception e){
               JOptionPane.showMessageDialog(null, "Please fill the form properly.");
           }
        }
    }//GEN-LAST:event_LogInButton4MouseClicked

    private void LogInButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogInButton3MouseClicked
       if(SubjectField.getText().equals("") || CreditField.getText().equals(""))
           JOptionPane.showMessageDialog(null, "Please complete the form.");
       else
       {
           try {
           core.add(new core(SubjectField.getText(),Integer.parseInt(CreditField.getText())));
           SubjectField.setText("");
           CreditField.setText("");
           } catch(Exception e){
               JOptionPane.showMessageDialog(null, "Please fill the form propely.");
           }
       }
    }//GEN-LAST:event_LogInButton3MouseClicked

    private void CreateAccountButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateAccountButton1MouseClicked
        int roll=teacher.size()+1;
        if(Arrays.equals(TPassField.getPassword(),TRPassField.getPassword()) && !TNameField.getText().equals("") && !AddressField1.getText().equals("") && !TSubjectSelection.getSelectedItem().equals("<Select Your Subject>") && !FacultyAdvisor.getSelectedItem().equals("<Are you a Faculty Advisor?>") && !TRegNoField.getText().equals(""))
        {
            teacher.add(new teacher(TNameField.getText(),AddressField1.getText(), (String) TSubjectSelection.getSelectedItem(),TRegNoField.getText(),"T"+roll,TPassField.getPassword(),(String) FacultyAdvisor.getSelectedItem()));
            JOptionPane.showMessageDialog(null,"Your ERP Registration Number is T"+roll);
            TeacherPanel.setVisible(true);
            TeacherSignupPanel.setVisible(false);
            TPassField.setText(null);
            TRPassField.setText(null);
            TNameField.setText(null);
            AddressField1.setText(null);
            TRegNoField.setText(null);
            TSubjectSelection.setSelectedIndex(0);
            
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Please fill up the form.");
            TPassField.setText(null);
            TRPassField.setText(null);
        }
    }//GEN-LAST:event_CreateAccountButton1MouseClicked

    private void CreateAccountButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateAccountButtonMouseClicked
        int roll=stud.size()+1;
        if(!Arrays.equals(SPassField.getPassword(),SRPassField.getPassword()) || SNameField.getText().equals("") || AddressField.getText().equals("") || SRegNoField.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please Fill up the form.");
            SPassField.setText(null);
            SRPassField.setText(null);
        }
        else
        {
            stud.add(new student(SNameField.getText(),AddressField.getText(),SRegNoField.getText(),"S"+roll,SPassField.getPassword(),0));
            JOptionPane.showMessageDialog(null,"Your ERP Registration Number is S"+roll);
            StudentSignupPanel.setVisible(false);
            StudentPanel.setVisible(true);
            SPassField.setText(null);
            SRPassField.setText(null);
            SNameField.setText(null);
            AddressField.setText(null);
            SRegNoField.setText(null);
        }
    }//GEN-LAST:event_CreateAccountButtonMouseClicked

    private void LogoutStudentButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutStudentButtonMouseClicked
       StudentPanel.setVisible(true);
       StudentAcadPanel.setVisible(false);
       PassField.setText("");
       RegField.setText("");
    }//GEN-LAST:event_LogoutStudentButtonMouseClicked

    private void LogoutTeacherButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutTeacherButtonMouseClicked
        TeacherPanel.setVisible(true);
        TeacherAcadPanel.setVisible(false);
        PassField2.setText("");
        RegField2.setText("");
    }//GEN-LAST:event_LogoutTeacherButtonMouseClicked

    private void LogInButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogInButton2MouseClicked
       try {
        if(Integer.parseInt(RegField2.getText().substring(1,RegField2.getText().length()))>teacher.size())
        {
            JOptionPane.showMessageDialog(null, "Invalid Registration Number.Please re-enter.");
            
        }
        else
        {
            if(Arrays.equals(teacher.get(Integer.parseInt(RegField2.getText().substring(1,RegField2.getText().length()))-1).password(),PassField2.getPassword()))
            {
                if(teacher.get(Integer.parseInt(RegField2.getText().substring(1,RegField2.getText().length()))-1).isFacad==true)
                    TeacherfAcadPanel.setVisible(true);
                else
                    TeacherAcadPanel.setVisible(true);
                TeacherPanel.setVisible(false);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Wrong Password.Please re-enter.");
            }
        }
       }catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, "Please fill up the form properly.");
       }
    }//GEN-LAST:event_LogInButton2MouseClicked

    private void SPassFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPassFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SPassFieldActionPerformed

    private void AddElectiveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddElectiveButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddElectiveButtonActionPerformed

    private void SRegistrationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SRegistrationButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SRegistrationButtonActionPerformed

    private void SAABackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SAABackButtonMouseClicked
        StudentAcadActPanel.setVisible(false);
        StudentAcadPanel.setVisible(true);
    }//GEN-LAST:event_SAABackButtonMouseClicked

    private void SAABackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SAABackButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SAABackButtonActionPerformed

    private void StudentRegButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentRegButtonMouseClicked
        StudentAcadActPanel.setVisible(true);
        StudentAcadPanel.setVisible(false);
        CoreArea.setText("");
        ElectiveList.removeAll();
        DefaultListModel model1=new DefaultListModel();
        int i;
        for(i=0;i<core.size();i++)
            CoreArea.append(core.get(i).name()+"( "+core.get(i).credit()+" )"+"\n");
        for(i=0;i<el.size();i++)
            model1.addElement(el.get(i).name()+"( "+el.get(i).credit()+" )");
        ElectiveList.setModel(model1);
    }//GEN-LAST:event_StudentRegButtonMouseClicked

    private void AddElectiveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddElectiveButtonMouseClicked
        if(el.size()-ElectiveList.getLastVisibleIndex()<=Integer.parseInt(ElectiveLabel.getText().substring(ElectiveLabel.getText().length()-1)))
        {
            for(int i=0;i<el.size();i++)
                if(el.get(i).name().equalsIgnoreCase(((String)ElectiveList.getSelectedValue()).substring(0,((String)ElectiveList.getSelectedValue()).length()-5)+""))
                {
                    stud.get(Integer.parseInt(RegField.getText().substring(1))-1).elect.add(new elect(el.get(i).name(),0,el.get(i).credit()));
                    break;
                }
            DefaultListModel model=(DefaultListModel)ElectiveList.getModel();
            int selectedIndex = ElectiveList.getSelectedIndex();
            if (selectedIndex != -1) 
                model.remove(selectedIndex);
        }
        else
            JOptionPane.showMessageDialog(null,"You have selected all your electives.");
        stud.get(Integer.parseInt(RegField.getText().substring(1))-1).registered=false;
        stud.get(Integer.parseInt(RegField.getText().substring(1))-1).isGraded=false;
    }//GEN-LAST:event_AddElectiveButtonMouseClicked

    private void SRegistrationButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SRegistrationButtonMouseClicked
        int i;
        for(i=0;i<core.size();i++)
            stud.get(Integer.parseInt(RegField.getText().substring(1))-1).coresub.add(new cores(core.get(i).name(),0,core.get(i).credit));
        stud.get(Integer.parseInt(RegField.getText().substring(1))-1).registered=true;
        stud.get(Integer.parseInt(RegField.getText().substring(1))-1).isGraded=false;
        JOptionPane.showMessageDialog(null,"You have been successfully registered.");
        StudentAcadActPanel.setVisible(false);
        StudentAcadPanel.setVisible(true);
    }//GEN-LAST:event_SRegistrationButtonMouseClicked

    private void LogoutTeacherButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutTeacherButton1MouseClicked
        TeacherPanel.setVisible(true);
        TeacherfAcadPanel.setVisible(false);
        PassField2.setText("");
        RegField2.setText("");
    }//GEN-LAST:event_LogoutTeacherButton1MouseClicked

    private void LogoutTeacherButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutTeacherButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutTeacherButton1ActionPerformed

    private void SignRegButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignRegButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SignRegButton1ActionPerformed

    private void SignRegButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignRegButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SignRegButton2ActionPerformed

    private void SignRegButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignRegButton1MouseClicked
        TeacherfAcadPanel.setVisible(false);
        SignCardPanel.setVisible(true);
        SignCardArea.setText(null);
        int i;
        for(i=0;i<stud.size();i++)
            if(stud.get(i).signed==false && stud.get(i).registered==true)
            {
                SignCardArea.append(stud.get(i).rollno()+" "+stud.get(i).name()+"\n");
                stud.get(i).signed=true;
            }
    }//GEN-LAST:event_SignRegButton1MouseClicked

    private void SignRegButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignRegButton2MouseClicked
        JOptionPane.showMessageDialog(null,"Successfully Signed All Registration Card.");
        TeacherfAcadPanel.setVisible(true);
        SignCardPanel.setVisible(false);
    }//GEN-LAST:event_SignRegButton2MouseClicked

    private void TeacherfAcadPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TeacherfAcadPanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TeacherfAcadPanelMouseClicked

    private void GradeTeacherButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GradeTeacherButton1MouseClicked
        int i,j;
        for(i=0;i<stud.size();i++)
            for(j=0;j<stud.get(i).coresub.size();j++)
                if(stud.get(i).coresub.get(j).name.equalsIgnoreCase(teacher.get(Integer.parseInt(RegField2.getText().substring(1))-1).subject()) && stud.get(i).registered==true)
                {
                    JFrame frame=new JFrame();
                    Object [] possibilities={"EX","A","B","C","D","F"};
                    String s = (String)JOptionPane.showInputDialog(frame,"Name:\n"+stud.get(i).name()+"\nRoll Number:\n"+stud.get(i).rollno(),"Enter Grade",
                    JOptionPane.PLAIN_MESSAGE,null,possibilities,"EX");
                    if ((s != null) && (s.length() > 0))
                    {
                        String grade=s;
                        if(grade.equalsIgnoreCase("EX"))
                            stud.get(i).coresub.get(j).grade=10;
                        else if(grade.equalsIgnoreCase("A"))
                            stud.get(i).coresub.get(j).grade=9;
                        else if(grade.equalsIgnoreCase("B"))
                            stud.get(i).coresub.get(j).grade=8;
                        else if(grade.equalsIgnoreCase("C"))
                            stud.get(i).coresub.get(j).grade=7;
                        else if(grade.equalsIgnoreCase("D"))
                            stud.get(i).coresub.get(j).grade=6;
                        else
                            stud.get(i).coresub.get(j).grade=0;
                        stud.get(i).isGraded=true;
                    }
                    break;
                }
        for(i=0;i<stud.size();i++)
            for(j=0;j<stud.get(i).elect.size();j++)
                if(stud.get(i).registered==true && stud.get(i).elect.get(j).name.equalsIgnoreCase(teacher.get(Integer.parseInt(RegField2.getText().substring(1))-1).subject()))
                {
                    JFrame frame=new JFrame();
                    Object [] possibilities={"EX","A","B","C","D","F"};
                    String s = (String)JOptionPane.showInputDialog(frame,"Name:\n"+stud.get(i).name()+"\nRoll Number:\n"+stud.get(i).rollno(),"Enter Grade",
                    JOptionPane.PLAIN_MESSAGE,null,possibilities,"EX");
                    if ((s != null) && (s.length() > 0))
                    {
                        String grade=s;
                        if(grade.equalsIgnoreCase("EX"))
                            stud.get(i).elect.get(j).grade=10;
                        else if(grade.equalsIgnoreCase("A"))
                            stud.get(i).elect.get(j).grade=9;
                        else if(grade.equalsIgnoreCase("B"))
                            stud.get(i).elect.get(j).grade=8;
                        else if(grade.equalsIgnoreCase("C"))
                            stud.get(i).elect.get(j).grade=7;
                        else if(grade.equalsIgnoreCase("D"))
                            stud.get(i).elect.get(j).grade=6;
                        else
                            stud.get(i).elect.get(j).grade=0;
                        stud.get(i).isGraded=true;
                    }
                    break;
                }
    }//GEN-LAST:event_GradeTeacherButton1MouseClicked

    private void GradeTeacherButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GradeTeacherButtonMouseClicked
        int i,j;
        for(i=0;i<stud.size();i++)
            for(j=0;j<stud.get(i).coresub.size();j++)
                if(stud.get(i).registered==true && stud.get(i).coresub.get(j).name.equalsIgnoreCase(teacher.get(Integer.parseInt(RegField2.getText().substring(1))-1).subject()))
                {
                    JFrame frame=new JFrame();
                    Object [] possibilities={"EX","A","B","C","D","F"};
                    String s = (String)JOptionPane.showInputDialog(frame,"Name:\n"+stud.get(i).name()+"\nRoll Number:\n"+stud.get(i).rollno(),"Enter Grades",
                    JOptionPane.PLAIN_MESSAGE,null,possibilities,"EX");
                    if ((s != null) && (s.length() > 0))
                    {
                        String grade=s;
                        if(grade.equalsIgnoreCase("EX"))
                            stud.get(i).coresub.get(j).grade=10;
                        else if(grade.equalsIgnoreCase("A"))
                            stud.get(i).coresub.get(j).grade=9;
                        else if(grade.equalsIgnoreCase("B"))
                            stud.get(i).coresub.get(j).grade=8;
                        else if(grade.equalsIgnoreCase("C"))
                            stud.get(i).coresub.get(j).grade=7;
                        else if(grade.equalsIgnoreCase("D"))
                            stud.get(i).coresub.get(j).grade=6;
                        else
                            stud.get(i).coresub.get(j).grade=0;
                        stud.get(i).isGraded=true;
                    }
                    break;
                }
        for(i=0;i<stud.size();i++)
            for(j=0;j<stud.get(i).elect.size();j++)
                if(stud.get(i).registered==true && stud.get(i).elect.get(j).name.equalsIgnoreCase(teacher.get(Integer.parseInt(RegField2.getText().substring(1))-1).subject()))
                {
                    JFrame frame=new JFrame();
                    Object [] possibilities={"EX","A","B","C","D","F"};
                    String s = (String)JOptionPane.showInputDialog(frame,"Name:\n"+stud.get(i).name()+"\nRoll Number:\n"+stud.get(i).rollno(),"Enter Grades",
                    JOptionPane.PLAIN_MESSAGE,null,possibilities,"EX");
                    if ((s != null) && (s.length() > 0))
                    {
                        String grade=s;
                        if(grade.equalsIgnoreCase("EX"))
                            stud.get(i).elect.get(j).grade=10;
                        else if(grade.equalsIgnoreCase("A"))
                            stud.get(i).elect.get(j).grade=9;
                        else if(grade.equalsIgnoreCase("B"))
                            stud.get(i).elect.get(j).grade=8;
                        else if(grade.equalsIgnoreCase("C"))
                            stud.get(i).elect.get(j).grade=7;
                        else if(grade.equalsIgnoreCase("D"))
                            stud.get(i).elect.get(j).grade=6;
                        else
                            stud.get(i).elect.get(j).grade=0;
                        stud.get(i).isGraded=true;
                    }
                    break;
                }
    }//GEN-LAST:event_GradeTeacherButtonMouseClicked

    private void LogoutStudentButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutStudentButton1MouseClicked
        StudentAcadInfoPanel.setVisible(false);
        StudentAcadPanel.setVisible(true);
    }//GEN-LAST:event_LogoutStudentButton1MouseClicked

    private void LogoutStudentButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutStudentButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutStudentButton1ActionPerformed

    private void GradeStudentButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GradeStudentButtonMouseClicked
        int roll=Integer.parseInt(RegField.getText().substring(1))-1;
        int i;
        double cg,sumcrd,totcrd;
        String s;
        if(stud.get(roll).isGraded==true && stud.get(roll).signed==true)
        {
            s="";
            StudentAcadInfoPanel.setVisible(true);
            StudentAcadPanel.setVisible(false);
            GradeArea.setText("");
            sumcrd=totcrd=0;
            for(i=0;i<stud.get(roll).coresub.size();i++)
            {
                s+=stud.get(roll).coresub.get(i).name+"\t"+stud.get(roll).coresub.get(i).grades()+"\n";
                sumcrd+=stud.get(roll).coresub.get(i).grade*stud.get(roll).coresub.get(i).credit;
                totcrd+=stud.get(roll).coresub.get(i).credit;
            }
            GradeArea.append(s);
            s="";
            for(i=0;i<stud.get(roll).elect.size();i++)
            {
                s+=stud.get(roll).elect.get(i).name+"\t"+stud.get(roll).elect.get(i).grades()+"\n";
                sumcrd+=stud.get(roll).elect.get(i).grade*stud.get(roll).elect.get(i).credit;
                totcrd+=stud.get(roll).elect.get(i).credit;
            }
            GradeArea.append(s);
            cg=sumcrd/totcrd;
            stud.get(roll).gpa=cg;
            CGPALabel.setText("CGPA:"+cg);
            if(cg>=9)
                JOptionPane.showMessageDialog(null,"Congratulations! Your have a great CGPA.");
            if(cg<=6)
                JOptionPane.showMessageDialog(null,"Your CGPA is not good. Work Harder!");
        }
        else
            JOptionPane.showMessageDialog(null,"Not Yet Registered or Graded");
        
    }//GEN-LAST:event_GradeStudentButtonMouseClicked

    private void ExitLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitLabelMouseClicked
        File file=null;
        OutputStream os=null;
        ObjectOutput oo=null;
        file=new File("E:\\students.ser");
        try {
            file.createNewFile();
            oo=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("E:\\students.ser")));
            oo.writeObject(stud);
            oo.close();
        } catch (Exception e) {
            Logger.getLogger(StartGUI.class.getName()).log(Level.SEVERE, null, e);
        }
        file=new File("E:\\teacher.ser");
        try {
            file.createNewFile();
            oo=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("E:\\teacher.ser")));
            oo.writeObject(teacher);
            oo.close();
        } catch (Exception e) {
            Logger.getLogger(StartGUI.class.getName()).log(Level.SEVERE, null, e);
        }
        file=new File("E:\\core.ser");
        try {
            file.createNewFile();
            oo=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("E:\\core.ser")));
            oo.writeObject(core);
            oo.close();
        } catch (Exception e) {
            Logger.getLogger(StartGUI.class.getName()).log(Level.SEVERE, null, e);
        }
        file=new File("E:\\elective.ser");
        try {
            file.createNewFile();
            oo=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("E:\\elective.ser")));
            oo.writeObject(el);
            oo.close();
        } catch (Exception e) {
            Logger.getLogger(StartGUI.class.getName()).log(Level.SEVERE, null, e);
        }
        System.exit(0);
    }//GEN-LAST:event_ExitLabelMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new StartGUI().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(StartGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddElectiveButton;
    private javax.swing.JTextField AddressField;
    private javax.swing.JTextField AddressField1;
    private javax.swing.JLabel CGPALabel;
    private javax.swing.JTextArea CoreArea;
    private javax.swing.JButton CoreButton;
    private javax.swing.JScrollPane CoreScrollPane;
    private javax.swing.JButton CreateAccountButton;
    private javax.swing.JButton CreateAccountButton1;
    private javax.swing.JTextField CreditField;
    private javax.swing.JTextField CreditField1;
    private javax.swing.JLabel ElectiveLabel;
    private javax.swing.JList ElectiveList;
    private javax.swing.JScrollPane ElectivePane;
    private javax.swing.JButton ElectiveSignRegButton;
    private javax.swing.JLabel ExitLabel;
    private javax.swing.JComboBox FacultyAdvisor;
    private javax.swing.JTextArea GradeArea;
    private javax.swing.JButton GradeStudentButton;
    private javax.swing.JButton GradeTeacherButton;
    private javax.swing.JButton GradeTeacherButton1;
    private javax.swing.JButton LogInButton;
    private javax.swing.JButton LogInButton1;
    private javax.swing.JButton LogInButton2;
    private javax.swing.JButton LogInButton3;
    private javax.swing.JButton LogInButton4;
    private javax.swing.JButton LogoutNomineeButton;
    private javax.swing.JButton LogoutStudentButton;
    private javax.swing.JButton LogoutStudentButton1;
    private javax.swing.JButton LogoutTeacherButton;
    private javax.swing.JButton LogoutTeacherButton1;
    private javax.swing.JTextField MaxElectiveField;
    private javax.swing.JButton NBackButton;
    private javax.swing.JButton NBackButton1;
    private javax.swing.JButton NBackButton2;
    private javax.swing.JPanel NomineeAcadPanel;
    private javax.swing.JButton NomineeButton;
    private javax.swing.JPanel NomineePanel;
    private javax.swing.JLabel OptionLabel;
    private javax.swing.JLabel OptionLabel1;
    private javax.swing.JLabel OptionLabel2;
    private javax.swing.JLabel OptionLabel3;
    private javax.swing.JLabel OptionLabel4;
    private javax.swing.JLabel OptionLabel5;
    private javax.swing.JLabel OptionLabel6;
    private javax.swing.JLabel OptionLabel7;
    private javax.swing.JPasswordField PassField;
    private javax.swing.JPasswordField PassField1;
    private javax.swing.JPasswordField PassField2;
    private javax.swing.JLabel PassLabel;
    private javax.swing.JLabel PassLabel1;
    private javax.swing.JLabel PassLabel2;
    private javax.swing.JLabel PassLabel3;
    private javax.swing.JLabel PassLabel4;
    private javax.swing.JLabel PassLabel5;
    private javax.swing.JLabel PassLabel6;
    private javax.swing.JTextField RegField;
    private javax.swing.JTextField RegField1;
    private javax.swing.JTextField RegField2;
    private javax.swing.JLabel RegLabel;
    private javax.swing.JLabel RegLabel1;
    private javax.swing.JLabel RegLabel10;
    private javax.swing.JLabel RegLabel11;
    private javax.swing.JLabel RegLabel12;
    private javax.swing.JLabel RegLabel2;
    private javax.swing.JLabel RegLabel3;
    private javax.swing.JLabel RegLabel4;
    private javax.swing.JLabel RegLabel5;
    private javax.swing.JLabel RegLabel6;
    private javax.swing.JLabel RegLabel7;
    private javax.swing.JLabel RegLabel8;
    private javax.swing.JLabel RegLabel9;
    private javax.swing.JButton SAABackButton;
    private javax.swing.JLabel SAALabel;
    private javax.swing.JButton SBackButton;
    private javax.swing.JButton SBackButton1;
    private javax.swing.JTextField SNameField;
    private javax.swing.JPasswordField SPassField;
    private javax.swing.JPasswordField SRPassField;
    private javax.swing.JTextField SRegNoField;
    private javax.swing.JButton SRegistrationButton;
    private javax.swing.JTextArea SignCardArea;
    private javax.swing.JScrollPane SignCardPane;
    private javax.swing.JPanel SignCardPanel;
    private javax.swing.JButton SignRegButton1;
    private javax.swing.JButton SignRegButton2;
    private javax.swing.JButton SignUpButton;
    private javax.swing.JButton SignUpButton2;
    private javax.swing.JLabel StartLabel;
    private javax.swing.JLabel StartLabel1;
    private javax.swing.JLabel StartLabel2;
    private javax.swing.JLabel StartLabel3;
    private javax.swing.JLabel StartLabel4;
    private javax.swing.JLabel StartLabel5;
    private javax.swing.JLabel StartLabel6;
    private javax.swing.JPanel StartPanel;
    private javax.swing.JPanel StudentAcadActPanel;
    private javax.swing.JPanel StudentAcadInfoPanel;
    private javax.swing.JPanel StudentAcadPanel;
    private javax.swing.JButton StudentButton;
    private javax.swing.JLabel StudentLabel;
    private javax.swing.JLabel StudentLabel1;
    private javax.swing.JLabel StudentLabel2;
    private javax.swing.JLabel StudentLabel3;
    private javax.swing.JLabel StudentLabel4;
    private javax.swing.JLabel StudentLabel5;
    private javax.swing.JLabel StudentLabel6;
    private javax.swing.JPanel StudentPanel;
    private javax.swing.JButton StudentRegButton;
    private javax.swing.JPanel StudentSignupPanel;
    private javax.swing.JTextField SubjectField;
    private javax.swing.JTextField SubjectField1;
    private javax.swing.JPanel SubjectSelectionPanel;
    private javax.swing.JPanel SubjectSelectionPanelE;
    private javax.swing.JButton TBackButton;
    private javax.swing.JButton TBackButton1;
    private javax.swing.JTextField TNameField;
    private javax.swing.JPasswordField TPassField;
    private javax.swing.JPasswordField TRPassField;
    private javax.swing.JTextField TRegNoField;
    private javax.swing.JComboBox TSubjectSelection;
    private javax.swing.JPanel TeacherAcadPanel;
    private javax.swing.JButton TeacherButton;
    private javax.swing.JPanel TeacherPanel;
    private javax.swing.JPanel TeacherSignupPanel;
    private javax.swing.JPanel TeacherfAcadPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
