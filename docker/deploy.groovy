/*
  Copyright © 2018 Booz Allen Hamilton. All Rights Reserved.
  This software package is licensed under the Booz Allen Public License. The license can be found in the License file or at http://boozallen.github.io/licenses/bapl
*/

def call() {
  stage "Deploying Docker Image Locally", {
    node{
      unstash "workspace"
      login_to_registry()
      def images = get_images_to_build()
      println("${images}")
      def img = images.find { it.repo == 'spring-boot-api' }
      println("${img.repo}")
      if ("${img.repo}" != null) {
        sh "docker run --rm -it -p 8088:8080 --network=try-it-out_sdp --name spring-boot-api ${img.registry}/${img.repo}:${img.tag}"
      }
    }
  }
}
