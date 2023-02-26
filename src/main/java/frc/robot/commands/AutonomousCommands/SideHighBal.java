package frc.robot.commands.AutonomousCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ClawCommands.Claw;
import frc.robot.commands.DriveCommands.DriveBackwardCommand;
import frc.robot.commands.DriveCommands.DriveForwardCommand;
import frc.robot.commands.DriveCommands.RotateLeftCommand;
import frc.robot.commands.DriveCommands.StrafeLeftCommand;
import frc.robot.commands.SequentialElevatorPivotCommands.Tucked;
import frc.robot.commands.SequentialElevatorPivotCommands.LowPickup;
import frc.robot.commands.SequentialElevatorPivotCommands.TopNode;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.PivotSubsystem;
import frc.robot.subsystems.SwerveSubsystem;


public class SideHighBal extends SequentialCommandGroup {


  // Start at Sides, Score High Node, Drive out to Pick-up Square, Strafe towards Charging-Station, Balance onto Charge-Station

  public SideHighBal(SwerveSubsystem swerve, ClawSubsystem claw, PivotSubsystem pivot, ElevatorSubsystem elevator) {
    
    addCommands(

      // Set elevator and pivot to high node
      new TopNode(pivot, elevator),

      // Drive forward slightly
      new DriveForwardCommand(swerve, 10),
  
      // Open claw
      new Claw(claw),

      // Drive backward slightly
      new DriveBackwardCommand(swerve, 10),
  
      // Set elevator to pick-up position
      new LowPickup(pivot, elevator),
  
      // Rotate 180
      new RotateLeftCommand(swerve, 180),

      // Drive forward to cube for pick-up
      new DriveForwardCommand(swerve, 100),

      // Open claw
      new Claw(claw),
  
      // Tuck in elevator and pivot
      new Tucked().getCommand(pivot, elevator),

      // Strafe inwards infront of charge-station
      new StrafeLeftCommand(swerve, 10), // On left side it would be right

      // Balance onto charge-station
      new IncrementBalanceCommand(swerve)
    );
  }
}
