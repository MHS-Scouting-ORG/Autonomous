package frc.robot.commands.ArmCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ElevatorCommands.HighPosition;
import frc.robot.commands.PivotCommands.PivotHighCmd;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.PivotSubsystem;

public class TopNode extends SequentialCommandGroup {

  // HIGH NODE POSITION
  public TopNode(PivotSubsystem pivotsub, ElevatorSubsystem elevsub) {

    addCommands(new HighPosition(elevsub),(new PivotHighCmd(pivotsub)));
  }
}