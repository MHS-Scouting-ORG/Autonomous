// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.commands;

// import com.ctre.phoenixpro.sim.CANcoderSimState;

// import edu.wpi.first.wpilibj.Timer;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj2.command.Command;
// import edu.wpi.first.wpilibj2.command.CommandBase;
// import edu.wpi.first.wpilibj2.command.Commands;
// import frc.robot.Constants.SwerveConsts;
// import frc.robot.subsystems.SwerveSubsystem;
// import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
// import frc.robot.commands.MovementCommands.DriveForwardCommand;
// import frc.robot.commands.MovementCommands.DriveBackwardCommand;
// import frc.robot.commands.MovementCommands.RotateLeftCommand;
// import frc.robot.commands.MovementCommands.StrafeRightCommand;


// public class testauto extends CommandBase {
//   private final SwerveSubsystem swerve; 
//   private Timer autoTimer; 

//   public testauto(SwerveSubsystem newSwerve) {
//     swerve = newSwerve; 
//     autoTimer = new Timer(); 

//     addRequirements(swerve);
//   }

//   // Called when the command is initially scheduled.
//   @Override
//   public void initialize() {
//     autoTimer.reset();
//     autoTimer.start();
//     SmartDashboard.putString("Auto?", "Yes, yes I am");
//   }

//   // Called every time the scheduler runs while the command is scheduled.
//   @Override
//   public void execute() {
//     SmartDashboard.putNumber("auto timer", autoTimer.get()); 
//     Commands.run(
//     () -> new SequentialCommandGroup(

//       new DriveForwardCommand(swerve), 

//       new DriveBackwardCommand(swerve), 

//       new RotateLeftCommand(swerve), 

//       new StrafeRightCommand(swerve)
//     ), swerve);
//   }

//   // Called once the command ends or is interrupted.
//   @Override
//   public void end(boolean interrupted) {
//     Commands.run(
//       () -> new Lock(swerve), 
//       swerve); 
//   }

//   // Returns true when the command should end.
//   @Override
//   public boolean isFinished() {
//     return autoTimer.get() >= 5;
//   }
// }
