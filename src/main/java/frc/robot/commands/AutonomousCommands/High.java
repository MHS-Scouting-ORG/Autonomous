package frc.robot.commands.AutonomousCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ArmCommands.HighAutoPositionParallel;
import frc.robot.commands.ArmCommands.Tucked;
import frc.robot.commands.ClawCommands.Claw;
import frc.robot.commands.MovementCommands.DriveBackwardCommand;
import frc.robot.commands.MovementCommands.DriveForwardCommand;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.PivotSubsystem;
import frc.robot.subsystems.SwerveSubsystem;
import frc.robot.commands.ArmCommands.Tucked;

public class High extends SequentialCommandGroup {

  //SCORE CONE ON HIGH NODE 
  public High(SwerveSubsystem swerve, ClawSubsystem claw, PivotSubsystem pivot, ElevatorSubsystem elevator) {

    addCommands(
      // High goal position (elevator up, pivot out) (parallel cmd)
      new HighAutoPositionParallel(pivot, elevator),

      // Move forward
      new DriveForwardCommand(swerve, 100),

      // Open claw
      new Claw(claw),

      // Move backward
      new DriveBackwardCommand(swerve, 100),

      // Arm in resting position (pivot in, elevator down) 
      new Tucked().getCommand(pivot, elevator)

    );
  }
}
