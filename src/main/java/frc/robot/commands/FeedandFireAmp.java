// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IPFSSub;

public class FeedandFireAmp extends Command {
  private final IPFSSub m_subsystem;
  private final Timer m_timer;
  /** Creates a new FeedandFire. */
  public FeedandFireAmp(IPFSSub subsystem) {
    m_subsystem = subsystem;
    addRequirements(m_subsystem);
    m_timer = new Timer();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_subsystem.Feed(0.167);
    m_subsystem.Shoot(.225);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.Feed(0);
    m_subsystem.Shoot(0);
    m_timer.stop();
    m_timer.reset();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (m_timer.get() >= 1.5){
      return true;
    }else{
      return false;
    }
  }
}
