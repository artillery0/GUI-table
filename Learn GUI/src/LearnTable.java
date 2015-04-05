import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LearnTable extends JFrame
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    Object[] titleRow =
    {
            "Name", "ID", "Age", "GPA", "Gender"
    };
    Object[][] tableData;
    int row;
    int col;
    JTable table;
    JScrollPane scrollPane;
    JButton BtnByName;
    JButton BtnByAge;
    JButton BtnByGPA;
    JButton BtnByID;
    Student[] studentArr;

    public LearnTable()
    {
        generateTable();
        table = new JTable(tableData, titleRow);

        scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        setLayout(new FlowLayout());

        BtnByName = new JButton("By Name");
        BtnByName.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Arrays.sort(studentArr);
                fillTable();
                table.repaint();
            }
        });
        add(BtnByName);

        BtnByAge = new JButton("By Age");
        BtnByAge.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Arrays.sort(studentArr, Student.byAge);
                fillTable();
                table.repaint();
            }
        });
        add(BtnByAge);

        BtnByGPA = new JButton("By GPA");
        BtnByGPA.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Arrays.sort(studentArr, Student.byGpa);
                fillTable();
                table.repaint();
            }
        });
        add(BtnByGPA);

        BtnByID = new JButton("By ID");
        BtnByID.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Arrays.sort(studentArr, Student.byID);
                fillTable();
                table.repaint();
            }
        });
        add(BtnByID);

        setVisible(true);
        pack();
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void generateTable()
    {
        String[] boyName =
        {
                "Alex", "Bosh", "Charlie", "Dickson", "Emerson", "Ferguson", "Gates", "Henry", "Ian", "Jake", "Kelvin"
        };
        String[] girlName =
        {
                "Alice", "Brith", "Christina", "Disney", "Emma", "Folwer", "Gayie", "Hush", "Ivan", "Jessy", "Kate"
        };
        int num = boyName.length + girlName.length; // number of rows
        studentArr = new Student[num];
        for (int i = 0; i < boyName.length; i++)
        {
            int age = (int) (Math.random() * 60);
            double gpa = Math.random() * 4.00;

            String name = boyName[i];
            long studentID = (int) (Math.random() * 900);
            studentArr[i] = new Student(age, gpa, name, studentID, 'M');
        }
        for (int i = boyName.length; i < num; i++)
        {
            int age = (int) (Math.random() * 60);
            double gpa = Math.random() * 4.00;
            String name = girlName[i - boyName.length];
            long studentID = (int) (Math.random() * 900);
            studentArr[i] = new Student(age, gpa, name, studentID, 'F');
        }
        row = num;
        col = titleRow.length;
        tableData = new Object[row][col];
        fillTable();
    }

    private void fillTable()
    {
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                switch (j)
                {
                    case 0:
                        tableData[i][j] = studentArr[i].name;
                        break;
                    case 1:
                        tableData[i][j] = studentArr[i].studentID;
                        break;
                    case 2:
                        tableData[i][j] = studentArr[i].age;
                        break;
                    case 3:
                        tableData[i][j] = new DecimalFormat("#.##").format(studentArr[i].gpa);
                        break;
                    case 4:
                        tableData[i][j] = studentArr[i].gender;
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedLookAndFeelException e)
        {
            e.printStackTrace();
        }

        new LearnTable();
    }

}