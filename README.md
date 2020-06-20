# What is it?

This is a little java application to control your Deebot (some models only) robotic vaccum cleaner based on values of a subscribed adafruit io feed. Initial effort was to perform basic control commands (i.e. clean, stop, charge) using Google Assistant. Since Google Assistant can be integrated with adafruit io feeds using IFTTT, this application can be used as the final block to complete commands pathway from GA all the way down to Deebot.

# Prerequisites in runtime environment
1) Java 
2) Python
3) Sucks python library - https://github.com/wpietri/sucks

# Build

Uses maven to build this into a single executable jar file.

# Remarks

Best way to use this to set it up as a service in a dedicated always up VM or a raspberri pi.

# Special Thanks

Special thanks to William Pietri who figured out the protocol to communicate with Deebot vaccum robot.
https://github.com/wpietri

