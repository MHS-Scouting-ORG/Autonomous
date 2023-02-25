package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SwerveSubsystem;

public class Lock extends CommandBase{
    
    private SwerveSubsystem swerve;

    private final Timer timer;
    public Lock(SwerveSubsystem subs){
        swerve = subs;
        timer = new Timer();

        addRequirements(subs);
    }

    @Override
    public void initialize(){
        timer.reset();
        timer.start();
    }

    @Override
    public void execute(){
        
    }

    @Override
    public void end(boolean interrupted){
        SmartDashboard.putString("Current Command", "Robot Locked!");
    }

    @Override
    public boolean isFinished(){
         return timer.get() > 5;
    }
}