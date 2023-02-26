package frc.robot.commands.ElevatorCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.PivotSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class LowPickup extends SequentialCommandGroup {
  /** Creates a new TuckedFromBottom. */
  public LowPickup(PivotSubsystem pivotSub, ElevatorSubsystem elevSub) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new MidPosition(elevSub), new PivotLowCmd(pivotSub), new LowPosition(elevSub));
  }
}