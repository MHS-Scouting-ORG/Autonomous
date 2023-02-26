package frc.robot.commands.AutonomousCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ClawCommands.Claw;
import frc.robot.commands.MovementCommands.DriveBackwardCommand;
import frc.robot.commands.MovementCommands.DriveForwardCommand;
import frc.robot.commands.MovementCommands.RotateRightCommand;
import frc.robot.commands.MovementCommands.StrafeLeftCommand;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.SwerveSubsystem;

public class SideHighBal extends SequentialCommandGroup {

  public SideHighBal(SwerveSubsystem swerve, ClawSubsystem claw) {

    //SCORE CONE ON A HIGH NODE, PICK UP A CUBE, THEN BALANCE 
    addCommands(
      // High goal position (elevator up, pivot out) 

      // Drive forward 
      new DriveForwardCommand(swerve, 100),

      // Open claw 
      new Claw(claw),

      // Drive backward 
      new DriveBackwardCommand(swerve, 100),

      // Arm in grabbing position (pivot in, elevator down) 

      // Turn to face cube 
      new RotateRightCommand(swerve, 100),

      // Forwards while tracking cube 
      new DriveForwardCommand(swerve, 100),

      // Claw close
      new Claw(claw),

      // Arm in resting/storage position (elevator up, pivot in) 

      // Strafe left (on left side it would be right)
      new StrafeLeftCommand(swerve, 100),

      // Backward onto Charge Station and balance
      new DriveBackwardCommand(swerve, 100)

    );
  }
}
