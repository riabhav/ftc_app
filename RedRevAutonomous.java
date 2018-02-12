


/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.ams.AMSColorSensor;
import com.qualcomm.hardware.lynx.LynxI2cColorRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.ColorSensor;

// import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;


@Autonomous(name="Autonomous Red", group="Tests")
//@Disabled
public class RedRevAutonomous extends LinearOpMode {

    /* Declare OpMode members. */
    // HardwarePushbot         robot   = new HardwarePushbot();   // Use a Pushbot's hardware
    HardwareMapRev robot = new HardwareMapRev();
    private ElapsedTime     runtime = new ElapsedTime();
    ColorSensor colorSensor;
    static final double     COUNTS_PER_MOTOR_REV    = 1440 ;    // eg: TETRIX Motor Encoder
    static final double     DRIVE_GEAR_REDUCTION    = 1.0 ;     // This is < 1.0 if geared UP
    static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;     // For figuring circumference
    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);
    //static final double     DRIVE_SPEED             = 0.6;
    static final double DRIVE_SPEED                 = 1.0;
    static final double     TURN_SPEED              = 0.5;

    @Override
    public void runOpMode() {

        /*
         * Initialize the drive system variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);


        /* Referencing, mapping  the color sensor */
        //colorSensor = hardwareMap.get(ColorSensor.class, "Color_Sensor");

        /* LED to be ON, helps to get a better color on the jewel */
        //colorSensor.enableLed(true);
        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Resetting Encoders");    //
        telemetry.update();

        //robot.leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // robot.rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.FrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.FrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.BackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.BackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        // robot.leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //robot.rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.FrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.FrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.BackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.BackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Send telemetry message to indicate successful Encoder reset
        //  telemetry.addData("Path0",  "Starting at %7d :%7d",
        //                  robot.leftDrive.getCurrentPosition(),
        //                 robot.rightDrive.getCurrentPosition());
        /*telemetry.addData("Path0",  "Starting at %7d :%7d :%7d :%7d",
                robot.FrontLeft.getCurrentPosition(),
                robot.FrontRight.getCurrentPosition(),
                robot.BackLeft.getCurrentPosition(),
                robot.BackRight.getCurrentPosition());

        telemetry.update();*/

        telemetry.addData("Status","Ready to run");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        /* Displays the color it sees */
       /* while(opModeIsActive()) {
            telemetry.addData("Color Number", robot.RevColorSensor.alpha());
            telemetry.update()
;        } */
        /*Drive forward for 1 seconds*/
        telemetry.addData("Status","Driving Forward");
        telemetry.update();
        glyphgrab();
  //      glyphlift();

        robot.FrontRight.setPower(1);
        robot.FrontLeft.setPower(1);
        robot.BackRight.setPower(1);
        robot.BackLeft.setPower(1);
        sleep(1000);

        robot.FrontRight.setPower(0.5);
        robot.FrontLeft.setPower(-0.5);
        robot.BackRight.setPower(0.5);
        robot.BackLeft.setPower(-0.5);
        sleep(500);

        robot.FrontRight.setPower(1);
        robot.FrontLeft.setPower(1);
        robot.BackRight.setPower(1);
        robot.BackLeft.setPower(1);
        sleep(400);

        glyphRelease();
        robot.FrontRight.setPower(0);
        robot.FrontLeft.setPower(0);
        robot.BackRight.setPower(0);
        robot.BackLeft.setPower(0);
     //   servoArmDown(1.0);
      //  red_jewel(0.5);
        // Step through each leg of the path,
        // Note: Reverse movement is obtained by setting a negative distance (not speed)
        //encoderDrive(DRIVE_SPEED,  15,  15, 5.0);  // S1: Forward 47 Inches with 5 Sec timeout
        //encoderDrive(TURN_SPEED,   6, -6, 4.0);  // S2: Turn Right 12 Inches with 4 Sec timeout
        //encoderDrive(DRIVE_SPEED, 3, 3, 4.0);  // S3: Reverse 24 Inches with 4 Sec timeout

        // robot.leftClaw.setPosition(1.0);            // S4: Stop and close the claw.
        // robot.rightClaw.setPosition(0.0);
        //sleep(1000);     // pause for servos to move

        telemetry.addData("Path", "Complete");
        telemetry.update();
    }

    public void glyphgrab()
    {
        while (opModeIsActive()){
            robot.servoClawLeftBottom.setPosition(1);
            robot.servoClawRightBottom.setPosition(1);
        }
    }

    public void glyphRelease()
    {
        while (opModeIsActive()) {
            robot.servoClawLeftBottom.setPosition(0);
            robot.servoClawRightBottom.setPosition(0);
        }
    }
    /*
     *  Method to perfmorm a relative move, based on encoder counts.
     *  Encoders are not reset as the move is based on the current position.
     *  Move will stop if any of three conditions occur:
     *  1) Move gets to the desired position//
     *  2) Move runs out of time
     *  3) Driver stops the opmode running.
     */
    public void encoderDrive(double speed,
                             double leftInches, double rightInches,
                             double timeoutS) {
        //int newLeftTarget;
        //int newRightTarget;
        int newFrontLeftTarget;
        int newFrontRightTarget;
        int newBackLeftTarget;
        int newBackRightTarget;


        // Ensure that the opmode is still active
        if (opModeIsActive()) {

            // Determine new target position, and pass to motor controller
            //newLeftTarget = robot.leftDrive.getCurrentPosition() + (int)(leftInches * COUNTS_PER_INCH);
            //newRightTarget = robot.rightDrive.getCurrentPosition() + (int)(rightInches * COUNTS_PER_INCH);
            newFrontLeftTarget = robot.FrontLeft.getCurrentPosition() + (int)(leftInches * COUNTS_PER_INCH);
            newBackLeftTarget = robot.BackLeft.getCurrentPosition() + (int)(leftInches * COUNTS_PER_INCH);
            newFrontRightTarget = robot.FrontRight.getCurrentPosition() + (int)(leftInches * COUNTS_PER_INCH);
            newBackRightTarget = robot.BackRight.getCurrentPosition() + (int)(leftInches * COUNTS_PER_INCH);

            //   robot.leftDrive.setTargetPosition(newLeftTarget);
            //  robot.rightDrive.setTargetPosition(newRightTarget);

            // Turn On RUN_TO_POSITION
            // robot.leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            // robot.rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.FrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.FrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.BackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.BackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // reset the timeout time and start motion.
            runtime.reset();
            // robot.leftDrive.setPower(Math.abs(speed));
            // robot.rightDrive.setPower(Math.abs(speed));
            robot.FrontRight.setPower(Math.abs(speed));
            robot.BackRight.setPower(Math.abs(speed));
            robot.FrontLeft.setPower(Math.abs(speed));
            robot.BackLeft.setPower(Math.abs(speed));

            // keep looping while we are still active, and there is time left, and both motors are running.
            // Note: We use (isBusy() && isBusy()) in the loop test, which means that when EITHER motor hits
            // its target position, the motion will stop.  This is "safer" in the event that the robot will
            // always end the motion as soon as possible.
            // However, if you require that BOTH motors have finished their moves before the robot continues
            // onto the next step, use (isBusy() || isBusy()) in the loop test.
            while (opModeIsActive() &&
                    (runtime.seconds() < timeoutS) &&
                    //   (robot.leftDrive.isBusy() && robot.rightDrive.isBusy())) {
                    (robot.FrontRight.isBusy() && robot.FrontLeft.isBusy() && robot.BackRight.isBusy() && robot.BackLeft.isBusy())) {
                // Display it for the driver.
                telemetry.addData("Path1",  "Running to %7d :%7d :%7d :%7d", newFrontLeftTarget,newBackLeftTarget, newFrontRightTarget, newBackRightTarget);
                // telemetry.addData("Path2",  "Running at %7d :%7d",
                //         robot.leftDrive.getCurrentPosition(),
                //         robot.rightDrive.getCurrentPosition());
                telemetry.update();
            }

            // Stop all motion;
            // robot.leftDrive.setPower(0);
            // robot.rightDrive.setPower(0);
            robot.FrontRight.setPower(0);
            robot.FrontLeft.setPower(0);
            robot.BackRight.setPower(0);
            robot.BackLeft.setPower(0);

            // Turn off RUN_TO_POSITION
            //  robot.leftDrive.setPower(0);
            //  robot.rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.FrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.FrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.BackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.BackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            //  sleep(250);   // optional pause after each move
        }
    }

    public void blue_jewel(double holdTime) {
        ElapsedTime holdTimer = new ElapsedTime();
        holdTimer.reset();
        while (opModeIsActive() && holdTimer.time() < holdTime) {
            if (colorSensor.blue() > 3) {
                encoderDrive(TURN_SPEED, -2, 2, 2.0);
                encoderDrive(TURN_SPEED, 2, -2, 2.0);
                robot.ArmServo.setPosition(0.0);
            } else {
                encoderDrive(TURN_SPEED, 2, -2, 2.0);
                encoderDrive(TURN_SPEED, -2, 2, 2.0);
                robot.ArmServo.setPosition(0.0);
            }
            robot.FrontLeft.setPower(0.0);
            robot.FrontRight.setPower(0.0);
            robot.BackLeft.setPower(0.0);
            robot.BackRight.setPower(0.0);
        }
    }

    public void servoArmDown(double holdTime){
        ElapsedTime holdTimer = new ElapsedTime();
        holdTimer.reset();
        while (opModeIsActive() && holdTimer.time()< holdTime) {
            robot.ArmServo.setPosition(1.0);
        }


    }
}
