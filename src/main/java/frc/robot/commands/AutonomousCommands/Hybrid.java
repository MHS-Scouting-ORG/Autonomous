package frc.robot.commands.AutonomousCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ClawCommands.Claw;
import frc.robot.commands.DriveCommands.DriveBackwardCommand;
import frc.robot.commands.DriveCommands.DriveForwardCommand;
import frc.robot.commands.SequentialElevatorPivotCommands.Tucked;
import frc.robot.commands.ElevatorCommands.MidPosition;
import frc.robot.commands.SequentialElevatorPivotCommands.LowPickup;
import frc.robot.commands.SequentialElevatorPivotCommands.MidNode;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.PivotSubsystem;
import frc.robot.subsystems.SwerveSubsystem;

public class Hybrid extends SequentialCommandGroup {


  // Standard Hybrid Scoring Auto

  public Hybrid(SwerveSubsystem swerve, ClawSubsystem claw, ElevatorSubsystem elevator, PivotSubsystem pivot) {
    
    addCommands(
      
      // Set elevator and pivot to hybrid position
      // (Inside here set elevator to low and pivot to)

      // Drive forward slightly
      new DriveForwardCommand(swerve, 10),
  
      // Open claw
      new Claw(claw),

      // Drive backward slightly
      new DriveBackwardCommand(swerve, 10),
      
      // Tuck in elevator and pivot
      new Tucked().getCommand(pivot, elevator)

    );
  }
}
