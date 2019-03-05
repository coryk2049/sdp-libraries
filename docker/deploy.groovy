/*
  Copyright © 2018 Booz Allen Hamilton. All Rights Reserved.
  This software package is licensed under the Booz Allen Public License. The license can be found in the License file or at http://boozallen.github.io/licenses/bapl
*/

def call() {
  stage "Deploying Docker Image", {
    node{
      unstash "workspace"
      login_to_registry()
      def images = get_images_to_build()
      def img = images.find { it == 'spring-boot-api' }
      if (img != null) {
        sh "docker run -t ${img.registry}/${img.repo}:${img.tag} --name ${img.repo}" 
      }
    }
  }
}
