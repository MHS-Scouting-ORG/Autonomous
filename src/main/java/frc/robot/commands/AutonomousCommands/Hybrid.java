package frc.robot.commands.AutonomousCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ClawCommands.Claw;
import frc.robot.commands.DriveCommands.DriveBackwardCommand;
import frc.robot.commands.DriveCommands.DriveForwardCommand;
import frc.robot.commands.ElevatorCommands.BringIn;
import frc.robot.commands.ElevatorCommands.MidPosition;
import frc.robot.commands.SequentialElevatorPivotCommands.HybridNode;
import frc.robot.commands.SequentialElevatorPivotCommands.MidNode;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.PivotSubsystem;
import frc.robot.subsystems.SwerveSubsystem;

public class Hybrid extends SequentialCommandGroup {

  public Hybrid(SwerveSubsystem swerve, ClawSubsystem claw, ElevatorSubsystem elevator, PivotSubsystem pivot) {
    
    addCommands(
      
      new HybridNode(pivot, elevator),

      new DriveForwardCommand(swerve, 10),

      new Claw(claw),

      new DriveBackwardCommand(swerve, 10),

      new BringIn(pivot, elevator)

    );
  }
}
