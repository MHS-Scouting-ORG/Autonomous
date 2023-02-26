package frc.robot.commands.SequentialElevatorPivotCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ElevatorCommands.LowPosition;
import frc.robot.commands.ElevatorCommands.MidPosition;
import frc.robot.commands.PivotCommands.PivotLowCommand;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.PivotSubsystem;

public class LowPickup extends SequentialCommandGroup {

  public LowPickup(PivotSubsystem pivotsub, ElevatorSubsystem elevsub) {

    addCommands(new MidPosition(elevsub), new PivotLowCommand(pivotsub), new LowPosition(elevsub));
  }
}
