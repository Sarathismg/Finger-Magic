# Finger-Magic
This repository contains the code for "Finger Magic", an application that uses desktop/laptop webcam feed to continuously detect finger motions without using very high CPU/GPU resources. We recorded at most 9% CPU usage on a notebook with CORE i5-7300HQ cpu while no finger gesture recognized, and a peak of 35% CPU usage for less than 2 seconds when a pre-defined gesture command received for a certain task(i.e.  shutdown, open a specific application, sleep etc.). This low resource usage makes it suitable for deployment in any machine with a webcam in it. We didn't find the deep learning solutions working so well, as quality of webcam varies significantly from notebook to notebook.

## How it works?
The detailed workflow will soon be published. 
