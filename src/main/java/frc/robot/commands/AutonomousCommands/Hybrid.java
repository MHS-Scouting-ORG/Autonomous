package frc.robot.commands.AutonomousCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Hybrid extends SequentialCommandGroup {
  /** Creates a new SideHybrid. */
  public Hybrid() {
    addCommands(
    // start lined up with community edge 
    // bring elev up and pivot out 
    // parallel command: bring arm back down and drive forward 
    //release claw 
    //move backward??? 
    );
  }
}
