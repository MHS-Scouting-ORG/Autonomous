package frc.robot.commands.AutonomousCommands.ArmCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ElevatorCommands.MidPosition;
import frc.robot.commands.PivotCommands.TuckedIn;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.PivotSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class TuckedFromBottom extends SequentialCommandGroup {
  /** Creates a new TuckedFromBottom. */
  public TuckedFromBottom(PivotSubsystem pivotSub, ElevatorSubsystem elevSub) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new MidPosition(elevSub), new TuckedIn(pivotSub));
  }
}