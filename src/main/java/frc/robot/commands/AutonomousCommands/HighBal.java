package frc.robot.commands.AutonomousCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ClawCommands.Claw;
import frc.robot.commands.DriveCommands.DriveBackwardCommand;
import frc.robot.commands.DriveCommands.DriveForwardCommand;
import frc.robot.commands.SequentialElevatorPivotCommands.Tucked;
import frc.robot.commands.SequentialElevatorPivotCommands.TopNode;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.PivotSubsystem;
import frc.robot.subsystems.SwerveSubsystem;

public class HighBal extends SequentialCommandGroup {

  
  // Start at Middle, Score High Node, Balance onto Charge-Station

  public HighBal(SwerveSubsystem swerve, ClawSubsystem claw, PivotSubsystem pivot, ElevatorSubsystem elevator) {

    addCommands(
      
      // Set elevator and pivot to high position
      new TopNode(pivot, elevator),

      // Drive forward slightly
      new DriveForwardCommand(swerve, 10),

      // Open claw
      new Claw(claw),

      // Drive backward slightly
      new DriveBackwardCommand(swerve, 10),

      // Tuck in elevator and pivot
      new Tucked().getCommand(pivot, elevator),

      // Balance onto charge-station incrementally
      new IncrementBalanceCommand(swerve)
    );
  }
}
