import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import com.simtechdata.jokes.Jokes;
import com.simtechdata.jokes.enums.Category;
import com.simtechdata.jokes.enums.Flag;

public class Main {

    static Jokes jokes = new Jokes.Builder().addCategory(Category.PUN).addBlackList(Flag.EXPLICIT, Flag.NSFW, Flag.SEXIST, Flag.RACIST, Flag.POLITICAL, Flag.RELIGIOUS).build();
    
    private static void createAndShowGUI() {
        JFrame jFrame = new JFrame("App that generates jokes");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(500, 360);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JTextArea blague = new JTextArea(jokes.getAny());
        blague.setEditable(false);
        blague.setLineWrap(true);
        blague.setWrapStyleWord(true);
        blague.setPreferredSize(new Dimension(400, 200));

        JButton refresh = new JButton("Refresh");
        jFrame.add(blague);
        refresh.addActionListener(e -> {
            blague.setText(jokes.getAny());
        });   
        jFrame.add(refresh);





        
        jFrame.setVisible(true);
    }


    public static void main(String[] args) {
        createAndShowGUI();
    }
}