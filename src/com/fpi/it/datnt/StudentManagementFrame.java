import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class StudentManagementFrame extends JFrame {
    private JTextField textFieldStudentID, textFieldName, textFieldAge, textFieldSearch;
    private JComboBox<String> comboBoxMajor;
    private JLabel labelSubject1, labelSubject2, labelSubject3;
    private JTextField textFieldScore1, textFieldScore2, textFieldScore3;
    private JButton btnAdd, btnEdit, btnDelete, btnSave;
    private JComboBox<String> comboBoxSort;
    private JTable table;
    private DefaultTableModel tableModel;
    private ArrayList<Student> students = new ArrayList<>();
    private DecimalFormat df = new DecimalFormat("#.##");
    private int selectedIndex = -1; 

    public StudentManagementFrame() {
        setTitle("Student Management");
        setSize(900, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(245, 255, 250));

        Font labelFont = new Font("Arial", Font.BOLD, 13);


        JLabel labelStudentID = new JLabel("Student ID:");
        labelStudentID.setBounds(20, 20, 80, 25);
        labelStudentID.setFont(labelFont);
        add(labelStudentID);

        textFieldStudentID = new JTextField();
        textFieldStudentID.setBounds(100, 20, 150, 25);
        add(textFieldStudentID);

        JLabel labelName = new JLabel("Name:");
        labelName.setBounds(20, 60, 80, 25);
        labelName.setFont(labelFont);
        add(labelName);

        textFieldName = new JTextField();
        textFieldName.setBounds(100, 60, 150, 25);
        add(textFieldName);

        JLabel labelAge = new JLabel("Age:");
        labelAge.setBounds(20, 100, 80, 25);
        labelAge.setFont(labelFont);
        add(labelAge);

        textFieldAge = new JTextField();
        textFieldAge.setBounds(100, 100, 150, 25);
        add(textFieldAge);

        JLabel labelMajor = new JLabel("Major:");
        labelMajor.setBounds(20, 140, 80, 25);
        labelMajor.setFont(labelFont);
        add(labelMajor);

        comboBoxMajor = new JComboBox<>(new String[]{"IT", "Design", "Business"});
        comboBoxMajor.setBounds(100, 140, 150, 25);
        add(comboBoxMajor);

        labelSubject1 = new JLabel("Subject 1");
        labelSubject1.setBounds(270, 20, 100, 25);
        add(labelSubject1);

        textFieldScore1 = new JTextField();
        textFieldScore1.setBounds(350, 20, 100, 25);
        add(textFieldScore1);

        labelSubject2 = new JLabel("Subject 2");
        labelSubject2.setBounds(270, 60, 100, 25);
        add(labelSubject2);

        textFieldScore2 = new JTextField();
        textFieldScore2.setBounds(350, 60, 100, 25);
        add(textFieldScore2);

        labelSubject3 = new JLabel("Subject 3");
        labelSubject3.setBounds(270, 100, 100, 25);
        add(labelSubject3);

        textFieldScore3 = new JTextField();
        textFieldScore3.setBounds(350, 100, 100, 25);
        add(textFieldScore3);


        btnAdd = new JButton("Add");
        btnAdd.setBounds(500, 20, 100, 25);
        btnAdd.setBackground(new Color(144, 238, 144));
        add(btnAdd);

        btnEdit = new JButton("Edit");
        btnEdit.setBounds(500, 60, 100, 25);
        btnEdit.setBackground(new Color(255, 228, 181));
        add(btnEdit);

        btnSave = new JButton("Save");
        btnSave.setBounds(500, 100, 100, 25);
        btnSave.setBackground(new Color(255, 215, 0));
        btnSave.setVisible(false);
        add(btnSave);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(620, 20, 100, 25);
        btnDelete.setBackground(new Color(255, 160, 122));
        add(btnDelete);

        comboBoxSort = new JComboBox<>(new String[]{
            "Sort by Student ID", 
            "Sort by Name", 
            "Sort by Age", 
            "Sort by Major", 
            "Sort by Average", 
            "Sort by Rank"
        });
        comboBoxSort.setBounds(620, 60, 180, 25);
        add(comboBoxSort);


        JLabel labelSearch = new JLabel("Search:");
        labelSearch.setBounds(20, 190, 80, 25);
        add(labelSearch);

        textFieldSearch = new JTextField();
        textFieldSearch.setBounds(100, 190, 150, 25);
        add(textFieldSearch);


        tableModel = new DefaultTableModel(
                new String[]{"Student ID", "Name", "Age", "Major", "Average", "Rank"}, 0);
        table = new JTable(tableModel);
        DefaultTableCellRenderer numberRenderer = new DefaultTableCellRenderer() {
            private DecimalFormat df = new DecimalFormat("#.##");
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus,
                                                           int row, int column) {
                if (value instanceof Number) {
                    value = df.format(((Number) value).doubleValue());
                }
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        };
        table.getColumnModel().getColumn(4).setCellRenderer(numberRenderer);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 230, 830, 450);
        add(scrollPane);


        comboBoxMajor.addActionListener(e -> updateSubjects());
        
        btnAdd.addActionListener(e -> addStudent());
        btnEdit.addActionListener(e -> editStudent());
        btnDelete.addActionListener(e -> deleteStudent());
        

        comboBoxSort.addActionListener(e -> {
            int sortOption = comboBoxSort.getSelectedIndex();
            sortStudents(sortOption);
            updateTable();
        });
        

        textFieldSearch.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                searchStudent();
            }
        });
        

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                selectedIndex = table.getSelectedRow();
                loadStudentFromTable();
            }
        });
        
        updateSubjects();
    }


    private void updateSubjects() {
        String major = comboBoxMajor.getSelectedItem().toString();
        switch (major) {
            case "IT":
                labelSubject1.setText("HTML");
                labelSubject2.setText("CSS");
                labelSubject3.setText("Math");
                break;
            case "Design":
                labelSubject1.setText("Color");
                labelSubject2.setText("Photoshop");
                labelSubject3.setText("AI");
                break;
            case "Business":
                labelSubject1.setText("Sales");
                labelSubject2.setText("Marketing");
                labelSubject3.setText("Finance");
                break;
        }
        textFieldScore1.setText("");
        textFieldScore2.setText("");
        textFieldScore3.setText("");
    }

    private void sortStudents(int sortOption) {
        if (students.size() <= 1) {
            return;
        }
        Student[] arr = new Student[students.size()];
        for (int i = 0; i < students.size(); i++) {
            arr[i] = students.get(i);
        }
        mergeSort(arr, 0, arr.length - 1, sortOption);
        students.clear();
        for (Student s : arr) {
            students.add(s);
        }
    }


    private void mergeSort(Student[] arr, int left, int right, int sortOption) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid, sortOption);
            mergeSort(arr, mid + 1, right, sortOption);
            merge(arr, left, mid, right, sortOption);
        }
    }


    private void merge(Student[] arr, int left, int mid, int right, int sortOption) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        Student[] leftArray = new Student[n1];
        Student[] rightArray = new Student[n2];
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (compareStudents(leftArray[i], rightArray[j], sortOption) <= 0) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }


    private int compareStudents(Student s1, Student s2, int sortOption) {
        switch (sortOption) {
            case 0:
                return s1.getId().compareToIgnoreCase(s2.getId());
            case 1:
                return s1.getName().compareToIgnoreCase(s2.getName());
            case 2:
                return s1.getAge() - s2.getAge();
            case 3:
                return s1.getMajor().compareToIgnoreCase(s2.getMajor());
            case 4:
                return Double.compare(s1.getAverage(), s2.getAverage());
            case 5:
                return s1.getRank().compareToIgnoreCase(s2.getRank());
            default:
                return 0;
        }
    }

 
    private double validateScore(String scoreStr) {
        double score = Double.parseDouble(scoreStr);
        if (score < 0 || score > 10) {
            throw new NumberFormatException();
        }
        return score;
    }


    private void addStudent() {
        try {
            String id = textFieldStudentID.getText().trim();
            for (Student st : students) {
                if (st.getId().equalsIgnoreCase(id)) {
                    JOptionPane.showMessageDialog(this, "Duplicate student data is not allowed!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            String name = textFieldName.getText().trim();
            int age = Integer.parseInt(textFieldAge.getText().trim());
            String major = comboBoxMajor.getSelectedItem().toString();
            double score1 = validateScore(textFieldScore1.getText().trim());
            double score2 = validateScore(textFieldScore2.getText().trim());
            double score3 = validateScore(textFieldScore3.getText().trim());
            double avg = (score1 + score2 + score3) / 3.0;
            avg = Double.parseDouble(df.format(avg));
            String rank = getRank(avg);

            students.add(new Student(id, name, age, major, score1, score2, score3, avg, rank));
            updateTable();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Please enter valid numbers for age and scores (scores must be between 0 and 10)!",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editStudent() {
        selectedIndex = table.getSelectedRow();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Please select a student to edit!");
            return;
        }
        try {
            Student s = students.get(selectedIndex);
            s.setId(textFieldStudentID.getText().trim());
            s.setName(textFieldName.getText().trim());
            s.setAge(Integer.parseInt(textFieldAge.getText().trim()));
            s.setMajor(comboBoxMajor.getSelectedItem().toString());
            double score1 = validateScore(textFieldScore1.getText().trim());
            double score2 = validateScore(textFieldScore2.getText().trim());
            double score3 = validateScore(textFieldScore3.getText().trim());
            s.setScore1(score1);
            s.setScore2(score2);
            s.setScore3(score3);
            double avg = (score1 + score2 + score3) / 3.0;
            avg = Double.parseDouble(df.format(avg));
            s.setAverage(avg);
            s.setRank(getRank(avg));
            updateTable();
            JOptionPane.showMessageDialog(this, "Saved successfully!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void deleteStudent() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a student to delete!");
            return;
        }
        students.remove(selectedRow);
        updateTable();
    }

    private void searchStudent() {
        String keyword = textFieldSearch.getText().trim().toLowerCase();
        tableModel.setRowCount(0);
        boolean found = false;
        for (Student s : students) {
            if (s.getId().toLowerCase().contains(keyword) ||
                s.getName().toLowerCase().contains(keyword)) {
                tableModel.addRow(new Object[]{
                    s.getId(), s.getName(), s.getAge(), s.getMajor(), s.getAverage(), s.getRank()
                });
                found = true;
            }
        }
        if (!found && !keyword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No matching student found.", "Search Result", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    private void updateTable() {
        tableModel.setRowCount(0);
        for (Student s : students) {
            tableModel.addRow(new Object[]{
                s.getId(), s.getName(), s.getAge(), s.getMajor(), s.getAverage(), s.getRank()
            });
        }
    }


    private void loadStudentFromTable() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            Student s = students.get(selectedRow);
            textFieldStudentID.setText(s.getId());
            textFieldName.setText(s.getName());
            textFieldAge.setText(String.valueOf(s.getAge()));
            comboBoxMajor.setSelectedItem(s.getMajor());
            updateSubjects();
            textFieldScore1.setText(String.valueOf(s.getScore1()));
            textFieldScore2.setText(String.valueOf(s.getScore2()));
            textFieldScore3.setText(String.valueOf(s.getScore3()));
        }
    }


    private String getRank(double avg) {
        if (avg < 5) return "Fail";
        else if (avg < 6.5) return "Medium";
        else if (avg < 7.5) return "Good";
        else if (avg < 9) return "Very Good";
        else return "Excellent";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentManagementFrame().setVisible(true));
    }
}

class Student {
    private String id, name, major, rank;
    private int age;
    private double score1, score2, score3, average;

    public Student(String id, String name, int age, String major, double score1,
                   double score2, double score3, double average, String rank) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.major = major;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.average = average;
        this.rank = rank;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    public double getScore1() { return score1; }
    public void setScore1(double score1) { this.score1 = score1; }

    public double getScore2() { return score2; }
    public void setScore2(double score2) { this.score2 = score2; }

    public double getScore3() { return score3; }
    public void setScore3(double score3) { this.score3 = score3; }

    public double getAverage() { return average; }
    public void setAverage(double average) { this.average = average; }

    public String getRank() { return rank; }
    public void setRank(String rank) { this.rank = rank; }
}
