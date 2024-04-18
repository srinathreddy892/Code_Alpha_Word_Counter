import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCountApp extends JFrame 
{
    private JTextArea textArea;
    private JButton countButton;
    private JLabel wordCountLabel;

    public WordCountApp()
     {
        setTitle("Word Count Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        countButton = new JButton("Count Words");
        wordCountLabel = new JLabel("Word Count: 0");

        countButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String paragraph = textArea.getText();
                int wordCount = countWords(paragraph);
                if (wordCount == -1) 
                {
                    JOptionPane.showMessageDialog(WordCountApp.this,
                            "Please enter some text to count words.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else 
                {
                    wordCountLabel.setText("Word Count: " + wordCount);
                }
            }
        });

        add(textArea, BorderLayout.CENTER);
        add(countButton, BorderLayout.SOUTH);
        add(wordCountLabel, BorderLayout.NORTH);

        setSize(400, 300); // Set the size of the window
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true);
    }

    private int countWords(String paragraph)
     {
        if (paragraph.trim().isEmpty())
        {
            return -1;
        }

        String[] words = paragraph.split("\\s+");
        return words.length;
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run() 
            {
                new WordCountApp();
            }
        });
    }
}
