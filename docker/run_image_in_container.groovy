/*
  Copyright © 2018 Booz Allen Hamilton. All Rights Reserved.
  This software package is licensed under the Booz Allen Public License. The license can be found in the License file or at http://boozallen.github.io/licenses/bapl
*/

def call(p_name, p_portmap, p_network) {
  stage "Running Docker Image in Container", {
    node{
      unstash "workspace"
      login_to_registry()
      def images = get_images_to_build()
      println("${images}")
      def img = images.find { it.repo == "${p_name}" }
      println("${img.repo}")
      if ("${img.repo}" != null) {
        sh "docker run --rm -p ${p_portmap} -d --network=${p_network} --name ${img.repo} ${img.registry}/${img.repo}:${img.tag}"
      }
    }
  }
}
