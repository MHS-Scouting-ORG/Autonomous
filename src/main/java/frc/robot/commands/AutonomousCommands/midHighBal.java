package frc.robot.commands.AutonomousCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class midHighBal extends SequentialCommandGroup {
  /** Creates a new midHighBal. */
  public midHighBal() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      //move backward 
      //arm into high position 
      //move forward til bumpers hit the edge of grid 
      //look for node and release claw 
      //parallel group: move backward and bring arm back 
    );
  }
}
