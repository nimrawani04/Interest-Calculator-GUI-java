import java.awt.*;
import java.awt.event.*;

public class SimpleInterestCalculator extends Frame implements ActionListener {

    Label PrincipalLabel, RateLabel, TimeLabel, SimpleInterestLabel, AmountLabel;
    TextField Principal, Rate, Time, SimpleInterest, Amount;
    Button Clear, Calculate;
    Color BackgroundColor = new Color(0x1E1F22);
    Color BackgroundColor2 = new Color(0x44444C);
    Color ForegroundColor = new Color(0xFFFFFF);

    SimpleInterestCalculator() {
        // set frame
        this.setTitle("Simple Interest Calculator");
        this.setSize(800, 600);
        this.setVisible(true);
        this.setLayout(null);
        this.setBackground(BackgroundColor);


        // create components
        PrincipalLabel = new Label("Principal");
        Principal = new TextField();
        RateLabel = new Label("Rate (%)");
        Rate = new TextField();
        TimeLabel = new Label("Time (years)");
        Time = new TextField();
        SimpleInterestLabel = new Label("Simple Interest");
        SimpleInterest = new TextField();
        AmountLabel = new Label("Amount");
        Amount = new TextField();
        Clear = new Button("Clear");
        Calculate = new Button("Calculate");

        // setting properties of components
        PrincipalLabel.setBounds(300, 100, 100, 20);
        PrincipalLabel.setBackground(BackgroundColor);
        PrincipalLabel.setForeground(ForegroundColor);

        RateLabel.setBounds(300, 150, 100, 20);
        RateLabel.setBackground(BackgroundColor);
        RateLabel.setForeground(ForegroundColor);

        TimeLabel.setBounds(300, 200, 100, 20);
        TimeLabel.setBackground(BackgroundColor);
        TimeLabel.setForeground(ForegroundColor);

        SimpleInterestLabel.setBounds(300, 250, 100, 20);
        SimpleInterestLabel.setBackground(BackgroundColor);
        SimpleInterestLabel.setForeground(ForegroundColor);

        AmountLabel.setBounds(300, 300, 100, 20);
        AmountLabel.setBackground(BackgroundColor);
        AmountLabel.setForeground(ForegroundColor);

        Principal.setBounds(400, 100, 100, 20);
        Principal.setForeground(ForegroundColor);
        Principal.setBackground(BackgroundColor2);

        Rate.setBounds(400, 150, 100, 20);
        Rate.setForeground(ForegroundColor);
        Rate.setBackground(BackgroundColor2);

        Time.setBounds(400, 200, 100, 20);
        Time.setForeground(ForegroundColor);
        Time.setBackground(BackgroundColor2);

        SimpleInterest.setBounds(400, 250, 100, 20);
        SimpleInterest.setForeground(ForegroundColor);
        SimpleInterest.setBackground(BackgroundColor2);
        SimpleInterest.setEditable(false);

        Amount.setBounds(400, 300, 100, 20);
        Amount.setForeground(ForegroundColor);
        Amount.setBackground(BackgroundColor2);
        Amount.setEditable(false);

        Clear.setBounds(200, 350, 100, 30);
        Clear.setBackground(BackgroundColor2);
        Clear.setForeground(ForegroundColor);

        Calculate.setBounds(500, 350, 100, 30);
        Calculate.setBackground(BackgroundColor2);
        Calculate.setForeground(ForegroundColor);


        //add components to frame
        this.add(PrincipalLabel);
        this.add(Principal);
        this.add(RateLabel);
        this.add(Rate);
        this.add(Time);
        this.add(TimeLabel);
        this.add(SimpleInterest);
        this.add(SimpleInterestLabel);
        this.add(Amount);
        this.add(AmountLabel);
        this.add(Amount);
        this.add(Clear);
        this.add(Calculate);


        //adding listeners for components
        Calculate.addActionListener(this);
        Clear.addActionListener(this);


        // implement window closing functionality
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Frame f = (Frame) e.getSource();
                f.dispose();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Clear")) {
            Principal.setText("");
            Rate.setText("");
            Time.setText("");
            SimpleInterest.setText("");
            Amount.setText("");
        }
        if (e.getActionCommand().equals("Calculate")) {
            double p = Double.parseDouble(Principal.getText());
            double r = Double.parseDouble(Rate.getText()) / 100;
            double t = Double.parseDouble(Time.getText());
            double si = p * r * t;
            SimpleInterest.setText(String.format("%.1f", si));

            double amt = si + p;
            Amount.setText(String.valueOf(amt));

        }

    }


    public static void main(String[] args) {
        new SimpleInterestCalculator();
    }
}
