package frc.robot.commands.AutonomousCommands.ArmCommands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.ElevatorCommands.MidPosition;
import frc.robot.commands.PivotCommands.TuckedIn;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.PivotSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class TuckedFromTop extends ParallelCommandGroup {
  /** Creates a new TuckedFromBottom. */
  public TuckedFromTop(PivotSubsystem pivotSub, ElevatorSubsystem elevSub) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new TuckedIn(pivotSub), new MidPosition(elevSub));
  }
}