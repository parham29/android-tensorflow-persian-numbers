# Android Image Classifier 

An android app for recognizing persian numbers with Tensorflow and android studio written in kotlin









 Number 1 |  Number 3  | Number 4 |
:-------------------------:|:-------------------------:|:-------------------------:
![first test](https://github.com/parham29/tensorflow-persian-numbers/blob/master/screenshots/test-1.jpg)  |  ![second test](https://github.com/parham29/tensorflow-persian-numbers/blob/master/screenshots/test-3.jpg)|![third test](https://github.com/parham29/tensorflow-persian-numbers/blob/master/screenshots/test-4.jpg)


## Getting Started

Just clone the project.

### Prerequisites

If you want to build your own image classifier you shoud install Tensorflow on your pc furthermore you need your own dataset.
Note: python (version 3.+) required.

this command are for windows users:
```
C:\> pip3 install --upgrade tensorflow
```
To install the GPU version of TensorFlow, enter the following command:
```
C:\> pip3 install --upgrade tensorflow-gpu
```
**Installing with Anaconda:**
1. Follow the instructions on the [Anaconda download site](https://www.continuum.io/downloads "Anaconda download site") to download and install Anaconda.
2. Create a conda environment named tensorflow by invoking the following command:
```
C:> conda create -n tensorflow pip python=3.5 
```
3. Activate the conda environment by issuing the following command:
```
C:> activate tensorflow
 (tensorflow)C:>  # Your prompt should change 
```
4. Issue the appropriate command to install TensorFlow inside your conda environment. To install the CPU-only version of TensorFlow, enter the following command:
```
(tensorflow)C:> pip install --ignore-installed --upgrade tensorflow 
```
To install the GPU version of TensorFlow, enter the following command (on a single line):
```
(tensorflow)C:> pip install --ignore-installed --upgrade tensorflow-gpu 
```

 for more help visit this [website][website].
 
### Usage
Flow of the app is pretty simple:
1. Take or pick a photo from storage.
2. Classify numbers.
3. Show the results and confidence(probability).


### Code structure
The app consists of two main components:
1. <code>MainActivity</code> which is responsible for taking a photo.
2. <code>ImageClassifier</code> which classifies the photo.

### Classifier
<code>ImageClassifier</code> properties:
- <code>inputName</code> - the name of the classifier's input (the photo pixels goes in there),
- <code>outputName</code> - the name of the classifier's output (the results can be found there),
- <code>imageSize</code> - the size of the photo,
- <code>labels</code> - the list of the labels (in our case "hot" and "not"),
- <code>imageBitmapPixels</code> - the array with bitmap pixels (int values before normalization),
- <code>imageNormalizedPixels</code> - the array with normalized pixels,
- <code>results</code> - the list with the results,
- <code>tensorFlowInference</code> - the TensorFlow API object (which is used for inference).

### Classification process
For classifying photos the app is using retrained [MobileNet](https://github.com/tensorflow/models/blob/master/research/slim/nets/mobilenet_v1.md "MobileNet") model. The model can be found inside the <code>assets</code> folder together with the labels file.

Before classification the photo needs to be prepared to fit the input of the classifier which is 224x224 pixels. Because of that the photo is resized and cropped which is happening inside the <code>ImageUtils</code>.

Prepared photo is passed to the <code>ImageClassifier</code>. The class responsibilities are as follows:
1. Nomalizing pixels of the photo - <code>preprocessImageToNormalizedFloats()</code> method.
2. Run the classifier: 
<code>tensorFlowInference.run(arrayOf(outputName), ENABLE_LOG_STATS)</code>
3. Get the results from the output: 
<code>tensorFlowInference.fetch(outputName, results)</code>

The results are then passed to the MainActivity and shown on the screen (including probability).

Special thanks to @makorowy

[website]: https://hackernoon.com/building-an-insanely-fast-image-classifier-on-android-with-mobilenets-in-tensorflow-dc3e0c4410d4 "https://hackernoon.com"
