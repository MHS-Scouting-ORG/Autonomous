package frc.robot.commands.AutonomousCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ArmCommands.LowPickup;
import frc.robot.commands.ArmCommands.TuckedFromBottom;
import frc.robot.commands.ClawCommands.OpenClaw;
import frc.robot.commands.MovementCommands.DriveBackwardCommand;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.PivotSubsystem;
import frc.robot.subsystems.SwerveSubsystem;

public class Hybrid extends SequentialCommandGroup {

  public Hybrid(SwerveSubsystem swerve, ClawSubsystem claw, PivotSubsystem pivot, ElevatorSubsystem elevator)  {

    //SCORE CONE IN HYBRID GOAL 
    addCommands(

    // start elev in mid position 

      // Arm in hybrid goal position (pivot out, elevator down) 
      new LowPickup(pivot, elevator),

      // Open claw 
      new OpenClaw(claw),

     // Arm in resting position (pivot in, elevator down) 
      new TuckedFromBottom(pivot, elevator),


      // Move backward
      new DriveBackwardCommand(swerve, 20)
    );
  }
}
